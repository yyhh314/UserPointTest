package com.example.demo.service;

import com.example.demo.dto.UserPointDto;
import com.example.demo.entity.UserPoint;
import com.example.demo.repository.UserPointRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPointRepository userPointRepository;

    public void createPoint(UserPointDto dto) {
        UserPoint userPoint = UserPoint.toEntity(dto);
        if (userPointRepository.findById(dto.getNickname()).isEmpty()) {
            log.info("[UserService] new user enters! | name : {}", dto.getNickname());
        }
        userPointRepository.save(userPoint);
    }

    // tmp user의 임시 닉네임 생성
    public String makeRandomName() {
        Faker faker = new Faker();
        Random random = new Random();
        int i;
        String result;

        // For Various Creations Of...

        do {
            // PREFIX
            String prefix = "";
            do {
                i = random.nextInt(5);
                switch (i) {
                    case 0 -> prefix = faker.color().name();
                    case 1 -> prefix = faker.weather().description();
                    case 2 -> prefix = faker.university().prefix();
                    case 3 -> prefix = faker.space().planet();
                    case 4 -> prefix = faker.music().genre();
                }
            } while (prefix.length() > 11);

            // NOUN
            String noun = "";
            do {
                i = random.nextInt(7);
                switch (i) {
                    case 0 -> noun = faker.animal().name();
                    case 1 -> noun = faker.food().dish();
                    case 2 -> noun = faker.music().instrument();
                    case 3 -> noun = faker.relationships().any();
                    case 4 -> noun = faker.job().position();
                    case 5 -> noun = faker.food().fruit();
                    case 6 -> noun = faker.food().vegetable();
                }
            } while (noun.length() > 11);


            // CONCAT!
            result = (prefix + " " + noun).trim().replace(" ", "_").toLowerCase(Locale.ROOT);
        } while(userPointRepository.findById(result).isPresent());

        log.info("[UserService] makeRandomName : {}", result);
        return result;
    }



    public List<UserPointDto> getAllPoint() {
        List<UserPoint> list = userPointRepository.findAll();

        List<UserPointDto> dtos = list.stream().map(x -> UserPointDto.toDto(x)).collect(Collectors.toList());
        return dtos;
    }

//    public void updatePoint(UserPointDto dto) {
//        UserPoint userPoint = UserPoint.toEntity(dto);
//        userPointRepository.save(userPoint);
//    }



}
