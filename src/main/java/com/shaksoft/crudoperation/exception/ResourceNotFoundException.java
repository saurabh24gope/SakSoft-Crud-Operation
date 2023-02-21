package com.shaksoft.crudoperation.exception;

import com.shaksoft.crudoperation.config.ApiConstants;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super(ApiConstants.RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
