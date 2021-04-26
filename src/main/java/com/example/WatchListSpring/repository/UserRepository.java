package com.example.WatchListSpring.repository;

import com.example.WatchListSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}