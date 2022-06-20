package com.alkemy.personajesDisney.exception;


public class ParamNotFound extends RuntimeException {
    public ParamNotFound(String errorMessage) {
        super(errorMessage);
    }
}
