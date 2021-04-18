package com.example.WatchListSpring;

import com.example.WatchListSpring.UserRepository;
import com.example.WatchListSpring.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /*User user = new User("test2Spring@empty.com", "mdp", "Spring", 1);
            userRepository.save(user);*/

            userRepository.findAll().forEach(System.out::println);
        };
    }
}