package com.restapi.livewebquizapp.service.impl;

import com.restapi.livewebquizapp.dtos.Responses.UserResponseDto;
import com.restapi.livewebquizapp.dtos.requests.UserRequestDto;
import com.restapi.livewebquizapp.exception.UserNotFoundException;
import com.restapi.livewebquizapp.model.User;
import com.restapi.livewebquizapp.repository.UserRepository;
import com.restapi.livewebquizapp.service.UserService;
import com.restapi.livewebquizapp.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User joinQuiz(UserRequestDto requestDto) {
        return userRepository.save(Mapper.mapToEntity(requestDto));
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> Mapper.mapToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateRound(Long id, UserRequestDto requestDto) {
        User user=userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
        user.setRound(requestDto.getRound());
        return Mapper.mapToDto(userRepository.save(user));
    }

    @Override
    public List<User> getResults() {
        return userRepository.findAll().stream().sorted(Comparator.comparing(User::getScore).reversed()).collect(Collectors.toList());
    }

}
