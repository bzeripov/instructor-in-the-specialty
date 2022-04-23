package hackaton.specialspring.services;

import hackaton.specialspring.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    Users regUser(Users user);
    boolean updatePassword(Users user, String oldPassword, String newPassword);
    Users updateAvatar(Users user);
}
