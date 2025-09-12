package com.example.demo1.repository;

import com.example.demo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 이름으로 검색
    List<User> findByName(String name);

    // 이메일에 특정 키워드가 포함된 사용자 검색
    List<User> findByEmailContaining(String keyword);

}
