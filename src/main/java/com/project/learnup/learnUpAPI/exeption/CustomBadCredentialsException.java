package com.project.learnup.learnUpAPI.exeption;

public class CustomBadCredentialsException extends RuntimeException{

    public CustomBadCredentialsException(String msg){
        super(msg);
    }
}
