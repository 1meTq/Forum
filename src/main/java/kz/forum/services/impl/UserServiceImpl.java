package kz.forum.services.impl;

import kz.forum.models.City;
import kz.forum.models.Roles;
import kz.forum.models.Users;
import kz.forum.repos.CityRepository;
import kz.forum.repos.RoleRepository;
import kz.forum.repos.UserRepository;
import kz.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(s);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users createUser(Users user) {
        Users checkUser = userRepository.findByEmail(user.getEmail());

        if (checkUser == null) {
            Roles role = roleRepository.findByRole("ROLE_USER");

            if (role != null) {

                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);

                if (user.getCity() != null) {
                    City c = cityRepository.findById(user.getCity().getId()).orElse(null);
                    user.setCity(c);
                }
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public Users getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users updateProfile(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updatePassword(Users user) {
        return null;
    }

    @Override
    public void deleteUser(Users user) {
        userRepository.delete(user);
    }
}
