package com.reis.reisworkshop.resources;

import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService service;


    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list =  service.findAll();
        return  ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> insert(@RequestBody  User obj){
       obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj
                        .getId()).toUri();
       return  ResponseEntity.created(uri).body(obj);
    }

}
