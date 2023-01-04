package com.example.demo.dto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PointDto{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
