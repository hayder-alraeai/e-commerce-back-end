package com.onlineshop.alraeaei.security.user.service;

import com.onlineshop.alraeaei.security.user.ApplicationUser;
import com.onlineshop.alraeaei.security.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findApplicationUserByEmail(email);
    }
    public ApplicationUser addUser(ApplicationUser user){
        if (userRepository.findAll().stream().anyMatch(p -> p.getEmail().equalsIgnoreCase(user.getEmail()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is busy!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
