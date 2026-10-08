package com.reis.reisworkshop.service;

import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        //User user = service.findById(id);
        Optional<User> obj = userRepository.findById(id);
        return obj.get();

    }
    public User insert(User obj){
        return userRepository.save(obj);
    }


}
