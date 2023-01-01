package com.restapi.livewebquizapp.controllers;

import com.restapi.livewebquizapp.dtos.Responses.APIResponse;
import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.service.AnswerService;
import com.restapi.livewebquizapp.utils.Responder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/answer")
public class AnswerController {
    private final AnswerService service;

    private final Responder responder;

    @PostMapping("/submitAnswer/{id}")
    public ResponseEntity<APIResponse> submitAnswer(@PathVariable (name = "id") Long id,
                                                    @RequestBody AnswerRequestDto requestDto){
        return responder.okay(service.submitAnswer(id, requestDto));
    }
}
