package com.reis.reisworkshop.config;

import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    // popular banco de dados para testes
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User use2r = new User( "Ray", "ray@gmail.com", "0343000", "123456");
        User use3r = new User( "rdzin", "rdzin@gmail.com", "05653000", "56523456");
        userRepository.saveAll(Arrays.asList(use2r, use3r));
    }
}
