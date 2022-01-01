package com.example.portfolio.repository;

import com.example.portfolio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email); // 같은은 이메 유저 확인
}
