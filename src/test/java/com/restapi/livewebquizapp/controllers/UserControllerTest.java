package com.restapi.livewebquizapp.controllers;

import com.restapi.livewebquizapp.dtos.Responses.UserResponseDto;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.model.User;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService service;

    @MockBean
    Responder responder;

    User user;

    UserRequestDto requestDto;

    UserResponseDto responseDto;

    Long DUMMY_ID = 1L;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setCode("u78");
        user.setEmail("gozie@gmail.com");
        user.setScore(78.0);
        user.setRound(3);

        requestDto = new UserRequestDto();
        requestDto.setCode("u8");
        requestDto.setEmail("prince@gmail.com");
        requestDto.setScore(98.0);
        requestDto.setRound(3);

        responseDto = new UserResponseDto();
        responseDto.setScore(40.0);
        responseDto.setRound(1);
    }

    @Test
    void joinQuiz() throws Exception {
        String url = "/api/user/joinQuiz";
        Mockito.when(service.joinQuiz(requestDto)).thenReturn(user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
          .contentType(MediaType.APPLICATION_JSON_VALUE).content(Mapper.mapToJson(requestDto))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);

    }

    @Test
    void getAllUsersParticipating() throws Exception {
        String url = "/api/user/getAllUsersParticipating";
        List<UserResponseDto> userList = new ArrayList<>();
        userList.add(responseDto);

        Mockito.when(service.getAllUsers()).thenReturn(userList);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(Mapper.mapToJson(responseDto))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    @Test
    void updateRound() throws Exception {
        String url = "/api/user/updateRound/1";
        Mockito.when(service.updateRound(DUMMY_ID, requestDto)).thenReturn(responseDto);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(Mapper.mapToJson(requestDto))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    @Test
    void getUsersByScore() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        String url = "/api/user/getUsersByScore";
        Mockito.when(service.getResults()).thenReturn(userList);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(Mapper.mapToJson(user))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }
}