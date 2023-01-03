package com.restapi.livewebquizapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.model.Answer;
import com.restapi.livewebquizapp.model.User;
import com.restapi.livewebquizapp.service.AnswerService;
import com.restapi.livewebquizapp.service.UserService;
import com.restapi.livewebquizapp.utils.Mapper;
import com.restapi.livewebquizapp.utils.Responder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class AnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AnswerService service;

    @MockBean
    Responder responder;

    User user;

    Answer answer;

    AnswerRequestDto answerRequestDto;

    Long DUMMY_ID = 1L;


    @BeforeEach
    void setUp() {
        user = new User();
        user.setCode("u78");
        user.setEmail("gozie@gmail.com");
        user.setScore(78.0);
        user.setRound(3);

        answer = new Answer();
        answer.setQuestionId(2);
        answer.setAnswer("yes");
        answer.setUser(user);

        answerRequestDto = new AnswerRequestDto();
        answerRequestDto.setQuestionId(2);
        answerRequestDto.setAnswer("yes");
    }

    @Test
    void submitAnswer() throws Exception {
        String url = "/api/answer/submitAnswer/3";
        Mockito.when(service.submitAnswer(DUMMY_ID, answerRequestDto)).thenReturn(answer);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(Mapper.mapToJson(answerRequestDto))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }
}