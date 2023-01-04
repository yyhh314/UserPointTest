package com.example.demo.repository;

import com.example.demo.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPointRepository extends JpaRepository<UserPoint, String> {
}
