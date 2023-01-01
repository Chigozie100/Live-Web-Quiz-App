package com.restapi.livewebquizapp.utils;

import com.restapi.livewebquizapp.dtos.Responses.UserResponseDto;
import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.model.Answer;
import com.restapi.livewebquizapp.model.User;

public class Mapper {
    public static User mapToEntity(UserRequestDto requestDto){
        User user = new User();
        user.setCode(requestDto.getCode());
        user.setEmail(requestDto.getEmail());
        user.setScore(requestDto.getScore());
        user.setRound(requestDto.getRound());
        return  user;
    }

    public static Answer mapToEntity(AnswerRequestDto requestDto){
        Answer answer = new Answer();
        answer.setQuestionId(requestDto.getQuestionId());
        answer.setAnswer(requestDto.getAnswer());
        return  answer;
    }

    public static UserResponseDto mapToDto(User user){
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setScore(user.getScore());
        responseDto.setRound(user.getRound());
        return responseDto;
    }
}
