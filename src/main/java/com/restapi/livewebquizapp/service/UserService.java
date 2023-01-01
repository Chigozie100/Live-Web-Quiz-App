package com.restapi.livewebquizapp.service;

import com.restapi.livewebquizapp.dtos.Responses.UserResponseDto;
import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.model.Answer;
import com.restapi.livewebquizapp.model.User;

import java.util.List;

public interface UserService {
    User joinQuiz(UserRequestDto requestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateRound(Long id, UserRequestDto requestDto);

    List<User> getResults();
}
