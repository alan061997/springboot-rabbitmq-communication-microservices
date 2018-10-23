package com.example.rabbit.microservicio2.repository;

import com.example.rabbit.microservicio2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
