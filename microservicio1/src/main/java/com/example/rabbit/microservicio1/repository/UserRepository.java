package com.example.rabbit.microservicio1.repository;

import com.example.rabbit.microservicio1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
