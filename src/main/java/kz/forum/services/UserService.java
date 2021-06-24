package kz.forum.services;

import kz.forum.models.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.*;

public interface UserService extends UserDetailsService {

    List<Users> allUsers();

    Users createUser(Users user);

    Users getUser(Long id);

    Users updateProfile(Users user);

    Users updatePassword(Users user);

    void deleteUser(Users user);

    Users findByEmail(String email);
}
