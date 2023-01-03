package com.restapi.livewebquizapp.controllers;

import com.restapi.livewebquizapp.dtos.Responses.APIResponse;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.service.UserService;
import com.restapi.livewebquizapp.utils.Responder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;
    private final Responder responder;

    @PostMapping("/joinQuiz")
    public ResponseEntity<APIResponse> joinQuiz(@RequestBody UserRequestDto requestDto){
        return responder.okay(service.joinQuiz(requestDto));
    }

    @GetMapping("/getAllUsersParticipating")
    public ResponseEntity<APIResponse> getAllUsersParticipating(){
        return responder.okay(service.getAllUsers());
    }

    @PutMapping("/updateRound/{round}")
    public ResponseEntity<APIResponse> updateRound(@PathVariable(name = "round") Long id,
                                                   @RequestBody UserRequestDto requestDto){
        return responder.okay(service.updateRound(id, requestDto));
    }

    @GetMapping("/getUsersByScore")
    public ResponseEntity<APIResponse> getUsersByScore(){
        return responder.okay(service.getResults());
    }
}
