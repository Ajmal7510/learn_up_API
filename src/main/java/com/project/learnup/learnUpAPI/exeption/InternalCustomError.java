package com.project.learnup.learnUpAPI.exeption;

public class InternalCustomError extends RuntimeException{
    public InternalCustomError(String serverError){
        super(serverError);
    }
}
