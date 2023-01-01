package com.restapi.livewebquizapp.utils;

import com.restapi.livewebquizapp.dtos.Responses.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Responder {
    public static ResponseEntity<APIResponse> notFound(String message){
        return new ResponseEntity<>(new APIResponse<>(message, true, null), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<APIResponse> okay(Object response){
        return new ResponseEntity<>(new APIResponse<>("Successfull", true, response), HttpStatus.OK);
    }

}

