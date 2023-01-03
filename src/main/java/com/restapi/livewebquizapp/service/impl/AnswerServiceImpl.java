package com.restapi.livewebquizapp.service.impl;

import com.restapi.livewebquizapp.dtos.requests.AnswerRequestDto;
import com.restapi.livewebquizapp.exception.UserNotFoundException;
import com.restapi.livewebquizapp.model.Answer;
import com.restapi.livewebquizapp.model.User;
import com.restapi.livewebquizapp.repository.AnswerRepository;
import com.restapi.livewebquizapp.repository.UserRepository;
import com.restapi.livewebquizapp.service.AnswerService;
import com.restapi.livewebquizapp.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.attribute.UnmodifiableSetException;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    private final UserRepository userRepository;
    @Override
    public Answer submitAnswer(Long id, AnswerRequestDto requestDto) {
        User user=userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));

        Answer answer=Mapper.mapToEntity(requestDto);
        answer.setUser(user);
        return answerRepository.save(answer);
    }
}
