package com.restapi.livewebquizapp.service.impl;

import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.model.Answer;
import com.restapi.livewebquizapp.model.User;
import com.restapi.livewebquizapp.repository.AnswerRepository;
import com.restapi.livewebquizapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AnswerServiceImplTest {
    @Mock
    UserRepository userRepository;

    @Mock
    AnswerRepository answerRepository;

    @InjectMocks
    AnswerServiceImpl answerService;

    AnswerRequestDto answerRequestDto;

    Answer answer;

    User user;

    Long DUMMY_ID = 3L;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setCode("90");
        user.setEmail("obh@gmail.com");
        user.setScore(60.0);
        user.setRound(2);

        answer = new Answer();
        answer.setQuestionId(2);
        answer.setAnswer("yes");
        answer.setUser(user);

        answerRequestDto = new AnswerRequestDto();
        answerRequestDto.setQuestionId(2);
        answerRequestDto.setAnswer("no");
    }

    @Test
    @DisplayName("submit answer")
    void submitAnswer() {
        Mockito.when(userRepository.findById(DUMMY_ID)).thenReturn(Optional.ofNullable(user));
        Mockito.when(answerRepository.save(any(Answer.class))).thenReturn(answer);
        Answer answer1=answerService.submitAnswer(DUMMY_ID, answerRequestDto);

        Assertions.assertNotNull(answer1);
        assertEquals(answerRequestDto.getQuestionId(), answer1.getQuestionId());
    }

}