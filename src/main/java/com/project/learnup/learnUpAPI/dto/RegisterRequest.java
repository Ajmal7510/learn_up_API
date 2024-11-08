package com.project.learnup.learnUpAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    public String fullName;
    public String phoneNumber;
    public String email;
    public String password;
}
