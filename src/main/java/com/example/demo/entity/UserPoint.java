package com.example.demo.entity;

import com.example.demo.dto.UserPointDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserPoint {

    @Id
    private String nickname;

    @Column
    private int x;

    @Column
    private int y;

    public static UserPoint toEntity(UserPointDto dto) {
        return new UserPoint(dto.getNickname(), dto.getPoint().getX(), dto.getPoint().getY());
    }

    public UserPoint(String nickname, int x, int y) {
        this.nickname = nickname;
        this.x = x;
        this.y = y;
    }
}