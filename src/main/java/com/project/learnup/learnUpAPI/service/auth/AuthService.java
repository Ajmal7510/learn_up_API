package com.project.learnup.learnUpAPI.service.auth;

import com.project.learnup.learnUpAPI.dto.RegisterRequest;
import com.project.learnup.learnUpAPI.enums.Role;
import com.project.learnup.learnUpAPI.exeption.InternalCustomError;
import com.project.learnup.learnUpAPI.exeption.UserAlreadyExistsException;
import com.project.learnup.learnUpAPI.modals.User;
import com.project.learnup.learnUpAPI.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> register(RegisterRequest request){

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User with email already exists");
        }




        try {

            User user=new User();
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setPhoneNumber(request.getPhoneNumber());
            user.setRole(Role.USER);


            userRepository.save(user);


        }catch (Exception e){
            throw new InternalCustomError(e.getMessage()+"ServerError");
        }

        return ResponseEntity.ok("Successfully Registered");

    }


}
