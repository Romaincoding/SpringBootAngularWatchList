package com.example.WatchListSpring;

import com.example.WatchListSpring.entity.*;
import com.example.WatchListSpring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

@SpringBootApplication
class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);





    }



    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /*User user = new User("test2Spring@empty.com", "mdp", "Spring", 1);
            userRepository.save(user);*/

            userRepository.findAll().forEach(System.out::println);
            System.out.println(userRepository.findById(1));
        };

    }
}