package com.restapi.livewebquizapp.exception;

import com.restapi.livewebquizapp.dtos.Responses.APIResponse;
import com.restapi.livewebquizapp.utils.Responder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse> droneNotFound(UserNotFoundException ex){
        return Responder.notFound(ex.getMessage());
    }
}
