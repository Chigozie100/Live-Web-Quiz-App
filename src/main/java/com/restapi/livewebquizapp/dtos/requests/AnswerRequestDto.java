package com.restapi.livewebquizapp.dtos.requests;

import lombok.Data;

@Data
public class AnswerRequestDto {
    private Integer questionId;
    private String answer;
}
