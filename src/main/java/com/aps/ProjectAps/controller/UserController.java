package com.aps.ProjectAps.controller;


import com.aps.ProjectAps.config.JwtService;
import com.aps.ProjectAps.entity.AuthRequest;
import com.aps.ProjectAps.entity.userInfo;
import com.aps.ProjectAps.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
    @RequestMapping(value = "addNewUser", method = RequestMethod.POST)
    public String addNewUser(@RequestBody userInfo userInfo) {
        return service.addUser(userInfo);
    }
    @RequestMapping(value = "user/userProfile", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }
    @RequestMapping(value = "admin/adminProfile", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @RequestMapping(value = "generateToken", method = RequestMethod.POST)
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        System.out.println(" authentication.isAuthenticated() "+authentication.isAuthenticated());
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
