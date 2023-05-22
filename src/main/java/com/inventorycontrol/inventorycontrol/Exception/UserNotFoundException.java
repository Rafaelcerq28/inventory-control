package com.inventorycontrol.inventorycontrol.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /*
     * Sending an 404 when the user is not found
     */

    public UserNotFoundException(String message){
        super(message);
    }
}
