package com.project.learnup.learnUpAPI.exeption;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
