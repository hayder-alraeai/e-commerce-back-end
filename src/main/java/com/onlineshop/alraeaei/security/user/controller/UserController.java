package com.onlineshop.alraeaei.security.user.controller;

import com.onlineshop.alraeaei.security.jwt.JwtUtils;
import com.onlineshop.alraeaei.security.jwt.RequestAuthenticationModel;
import com.onlineshop.alraeaei.security.jwt.ResponseAuthenticationModel;
import com.onlineshop.alraeaei.security.user.ApplicationUser;
import com.onlineshop.alraeaei.security.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseAuthenticationModel login(@RequestBody RequestAuthenticationModel requestAuthenticationModel) throws UsernameNotFoundException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    requestAuthenticationModel.getUsername(), requestAuthenticationModel.getPassword()
            ));
        }catch (ResponseStatusException e){
            System.out.println("wrong username or password");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect username or password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(requestAuthenticationModel.getUsername());
        final String token = jwtUtils.generateToken(userDetails);
        return new ResponseAuthenticationModel(token);
    }
    @PostMapping
    public ApplicationUser addNewUser(@RequestBody ApplicationUser applicationUser){
        System.out.println("register");
        if (userService.loadUserByUsername(applicationUser.getEmail()) != null){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username is busy");
        }
        return userService.addUser(applicationUser);
    }

}
