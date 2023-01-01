package com.restapi.livewebquizapp.repository;

import com.restapi.livewebquizapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
