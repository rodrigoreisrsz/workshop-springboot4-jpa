package com.reis.reisworkshop.service;

import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.repository.UserRepository;
import com.reis.reisworkshop.service.exceptions.ResourceNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }
    public User insert(User obj){
        return userRepository.save(obj);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return  userRepository.save(entity);

    }
    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
