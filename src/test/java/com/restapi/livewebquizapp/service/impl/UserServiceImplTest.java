package com.restapi.livewebquizapp.service.impl;

import com.restapi.livewebquizapp.dtos.Responses.UserResponseDto;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.model.User;
import com.restapi.livewebquizapp.repository.UserRepository;
import com.restapi.livewebquizapp.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    User user;

    UserRequestDto requestDto;

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
    }

    @Test
    @DisplayName("join Quiz")
    void joinQuiz() {
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        Assertions.assertNotNull(userService.joinQuiz(requestDto));
        assertEquals(requestDto.getRound(), user.getRound());
    }


    @Test
    @DisplayName(("get participating users"))
    void getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        List<UserResponseDto> responseDto=userService.getAllUsers();
        Assertions.assertNotNull(responseDto);
        assertEquals(user.getScore(), responseDto.get(0).getScore());
    }

    @Test
    @DisplayName("update round")
    void updateRound() {
        Mockito.when(userRepository.findById(DUMMY_ID)).thenReturn(Optional.ofNullable(user));
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        UserResponseDto responseDto=userService.updateRound(DUMMY_ID, requestDto);
        Assertions.assertNotNull(responseDto);
        assertEquals(user.getScore(), responseDto.getScore());
    }

    @Test
    @DisplayName("get results")
    void getResults() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        List<User> userList1=userService.getResults();
        Assertions.assertNotNull(userList1);
        assertEquals(user.getScore(), userList1.get(0).getScore());
    }
}