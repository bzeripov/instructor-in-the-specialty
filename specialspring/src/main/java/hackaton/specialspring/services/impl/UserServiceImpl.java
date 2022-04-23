package hackaton.specialspring.services.impl;

import hackaton.specialspring.entities.Roles;
import hackaton.specialspring.entities.Users;
import hackaton.specialspring.repositories.RoleRepository;
import hackaton.specialspring.repositories.UserRepository;
import hackaton.specialspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        if(user!=null){
            return user;
        }else {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
    }

    @Override
    public Users regUser(Users user){
        Users checUser = userRepository.findByEmail(user.getEmail());
        if(checUser==null){

            Roles userRole = roleRepository.findByRole("ROLE_USER");
            List<Roles> roles = new ArrayList<>();
            roles.add(userRole);
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean updatePassword(Users user, String oldPassword, String newPassword){

        Users checUser = userRepository.findByEmail(user.getEmail());

        if(passwordEncoder.matches(oldPassword, checUser.getPassword())){

            user.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(user)!=null;

        }else{
            return false;
        }

    }

    @Override
    public Users updateAvatar(Users user) {
        Users checUser = userRepository.findByEmail(user.getEmail());

        if(checUser!=null){
            checUser.setAvatar(user.getAvatar());
            return userRepository.save(checUser);
        }

        return null;

    }
}