package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NicknameDto {
    private String nickname;

    public NicknameDto(String nickname) {
        this.nickname = nickname;
    }
}
