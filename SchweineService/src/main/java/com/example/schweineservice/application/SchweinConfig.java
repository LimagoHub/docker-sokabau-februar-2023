package com.example.schweineservice.application;

import com.example.schweineservice.domain.SchweineRepository;
import com.example.schweineservice.domain.SchweineService;
import com.example.schweineservice.domain.impl.SchweineServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SchweinConfig {


    @Bean
    public List<String> bloedeSchweine() {
        return List.of("Elsa", "Peter", "Paul", "Mary");
    }

    @Bean
    public SchweineService createService(SchweineRepository repo,List<String> bloedeSchweine) {
        return new SchweineServiceImpl(repo, bloedeSchweine);
    }
}
