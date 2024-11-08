package com.project.learnup.learnUpAPI.exeption;

public class UsernameNotExist extends RuntimeException{
    public UsernameNotExist(String message){
        super(message);
    }
}
