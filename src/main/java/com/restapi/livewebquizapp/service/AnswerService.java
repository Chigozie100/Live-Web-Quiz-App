package com.restapi.livewebquizapp.service;

import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.model.Answer;

public interface AnswerService {
    Answer submitAnswer(Long id, AnswerRequestDto requestDto);

}
