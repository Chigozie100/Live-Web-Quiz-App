package com.restapi.livewebquizapp.dtos.requests;

import lombok.Data;

@Data
public class UserRequestDto {
    private String code;
    private String email;
    private Double score;
    private Integer round;
}
