package com.project.learnup.learnUpAPI.controller.auth;

import com.project.learnup.learnUpAPI.dto.RegisterRequest;
import com.project.learnup.learnUpAPI.service.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterRequest request){
        return authService.register(request);
    }


}
