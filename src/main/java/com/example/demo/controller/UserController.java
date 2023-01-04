package com.example.demo.controller;

import com.example.demo.dto.NicknameDto;
import com.example.demo.dto.PointDto;
import com.example.demo.dto.UserPointDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 비로그인 회원에게 tmp 닉네임 부여 & 생성까지
    @GetMapping("/create_userName")
    @ResponseBody
    public ResponseEntity createUserName(){
        String tmpName = userService.makeRandomName();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("nickname", tmpName);
        return ResponseEntity.status(HttpStatus.OK).body(hashMap.get("nickname"));
    }

    @GetMapping("/users")
    @ResponseBody
    // 나 뺴야함
    public ResponseEntity<List<UserPointDto>> getAllPoints(){
        return ResponseEntity.ok(userService.getAllPoint());
    }

    @PostMapping("/users/save")
    @ResponseBody
    public ResponseEntity saveUserPoint(@RequestBody UserPointDto dto){
        userService.createPoint(dto);
        return ResponseEntity.ok().build();
    }
}
