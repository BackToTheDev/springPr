package com.example.demo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // 생성 시간 (엔티티 처음 저장될 떄 자동 저장)
    @CreationTimestamp
    private LocalDateTime createdAt;

    // 수정 시간 (엔티티 변경할 때 마다 자동 갱신)
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
