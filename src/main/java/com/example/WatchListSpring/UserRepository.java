package com.example.WatchListSpring;

import com.example.WatchListSpring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}