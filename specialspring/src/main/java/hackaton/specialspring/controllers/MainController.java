package hackaton.specialspring.controllers;

import hackaton.specialspring.entities.Albums;
import hackaton.specialspring.entities.Sections;
import hackaton.specialspring.entities.Specialities;
import hackaton.specialspring.entities.Users;
import hackaton.specialspring.entities.forum.Answers;
import hackaton.specialspring.entities.forum.Questions;
import hackaton.specialspring.repositories.AlbumRepository;
import hackaton.specialspring.repositories.SectionsRepository;
import hackaton.specialspring.repositories.SpecialityRepository;
import hackaton.specialspring.repositories.UserRepository;
import hackaton.specialspring.repositories.forumRepository.AnswerRepository;
import hackaton.specialspring.repositories.forumRepository.QuestionRepository;
import hackaton.specialspring.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SectionsRepository sectionsRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(value = "signup")
    public String signUpPage(Model model){
        model.addAttribute("currentUser", getUser());
        return "signup";
    }

    @GetMapping("/speciality")
    public String speciality(Model model) {
        model.addAttribute("currentUser", getUser());
        return "speciality";
    }

    @GetMapping(value = "/forum")
    public String forum(Model model){
        List<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("sections", sections);
        return "forum/index";
    }

    @GetMapping("forum/{id}")
    public String bForum(@PathVariable("id") long id, Model model){
        List<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("sections", sections);
        Sections section = sectionsRepository.findById(id);
        model.addAttribute("section", section);
        List<Questions> questions1 = questionRepository.findAll();
        List<Questions> questions = new ArrayList<>();
        for(Questions question : questions1){
            if(question.getSection().getId() == id){
                questions.add(question);
            }
        }
        System.out.println(questions);
        model.addAttribute("questions", questions);
        List<Answers> answers1 = answerRepository.findAll();
        for(int i = 0; i < answers1.size() - 1; i++){
            for(int j = 0; j < answers1.size() - 1; j++){
                if(answers1.get(j).getRating() < answers1.get(j + 1).getRating()){
                    Answers tmp = answers1.get(j);
                    answers1.set(j, answers1.get(j + 1));
                    answers1.set(j + 1, tmp);
                }
            }
        }
        List<Answers> answers = new ArrayList<>();
        for(Answers answer : answers1){
            if(answer.getQuestion().getId() == id){
                answers.add(answer);
            }
        }
        model.addAttribute("answers", answers);
        return "forum/questions";
    }


    @GetMapping("forum/{id}/new")
    public String newQuestion(@PathVariable("id") long id, Model model, @ModelAttribute("question") Questions question){
        List<Sections> sections = sectionsRepository.findAll();
        Users user = getUser();
        if(user == null){
            return "redirect:/signin";
        }
        question.setUser(user);
        question.setSection(sectionsRepository.findById(id));
        model.addAttribute("sections", sections);
        model.addAttribute("id", id);
        return "forum/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("question") Questions question, Model model){
        System.out.println(question.getSection().getHeading());
        System.out.println(question.getUser().getEmail());
        questionRepository.save(question);
        return "redirect:/forum/";
    }

    @GetMapping (value = "faqs")
    public String faqs(Model model){
        model.addAttribute("currentUser", getUser());
        return "faqs";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("currentUser", getUser());
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signin(Model model){
        model.addAttribute("currentUser", getUser());
        return "signin";
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("isAuthenticated()")
        public String profile(Model model){
        model.addAttribute("currentUser", getUser());
        return "profile";
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String adminPanel(Model model){
        model.addAttribute("currentUser", getUser());
        return "admin";
    }

    @GetMapping(value = "/support")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    public String supportPanel(Model model){
        model.addAttribute("currentUser", getUser());
        return "support";
    }


    @GetMapping(value = "/accessdenied")
    public String accessdenied(Model model){
        model.addAttribute("currentUser", getUser());
        return "403";
    }

    @PostMapping(value = "signin")
    public String signUp(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_fullname") String fullName){

        Users newUser = userService.regUser(new Users(null,email,password,fullName,null,null));
        if(newUser!=null && newUser.getId()!=null){
            return "redirect:/signin?success";
        }
        return "redirect:/signuin?error";

    }
    @PostMapping(value = "/uploadava")
    @PreAuthorize("isAuthenticated()")
    public String uploadAva(@RequestParam(name = "user_avatar") MultipartFile file){

        Users currentUser = getUser();

        if(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")){
            try{

                String fileName = DigestUtils.sha1Hex(getUser().getId()+"_ava");

                byte bytes[] = file.getBytes();
                Path path = Paths.get(baseUrl+fileName+".jpg");

                Files.write(path, bytes);

                currentUser.setAvatar(fileName);
                userService.updateAvatar(currentUser);

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return "redirect:/profile";

    }

    @PostMapping(value = "/updatepassword")
    @PreAuthorize("isAuthenticated()")
    public String updatePassword(@RequestParam(name = "old_password") String oldPass,
                                 @RequestParam(name = "new_password") String newPass,
                                 @RequestParam(name = "re_new_password") String reNewPass){
        if(newPass.equals(reNewPass)){

            if(userService.updatePassword(getUser(), oldPass, newPass)){

                return "redirect:/profile?success";

            }

        }

        return "redirect:/profile?error";
    }

    private Users getUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            return (Users) authentication.getPrincipal();
        }else{
            return null;
        }
    }


    @GetMapping("/sections")
    public String sections(Model model){
        List<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("sections", sections);
        return "sections/block";
    }


    @GetMapping("/sections/{id}")
    public String specialities(@PathVariable("id")long id, Model model){
        Sections section = sectionsRepository.findById(id);
        model.addAttribute("section", section);
        List<Specialities> specialities = specialityRepository.findAll();
        List<Specialities> specialities1 = new ArrayList<>();
        for(Specialities speciality : specialities){
            if(speciality.getSectionId() == id){
                specialities1.add(speciality);
            }
        }
        model.addAttribute("specialities", specialities1);
        return "sections/specialities";
    }


    @GetMapping("/sections/{id}/{speciality_id}")
    public String album(@PathVariable("id")long id, @PathVariable("speciality_id") long speciality_id, Model model){
        Sections section = sectionsRepository.findById(id);
        model.addAttribute("section", section);
        Specialities speciality = specialityRepository.findById(speciality_id);
        model.addAttribute("speciality", speciality);
        List<Albums> albums = albumRepository.findAll();
        List<Albums> albums1 = new ArrayList<>();
        for(Albums album : albums){
            if(album.getSpecialityId() == speciality_id){
                albums1.add(album);
            }
        }
        model.addAttribute("albums", albums1);
        return "player/index";
    }

}
