package com.bank.Authentication.Controller;

import com.bank.Authentication.entity.AuthRequest;
import com.bank.Authentication.entity.Customer;
import com.bank.Authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String getToken(@RequestBody Customer customer) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getUserName(), customer.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authenticationService.generateToken(customer.getUserName());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authenticationService.validateToken(token);
        return "Token is valid";
    }


}
