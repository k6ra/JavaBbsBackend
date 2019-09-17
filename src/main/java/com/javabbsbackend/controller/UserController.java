package com.javabbsbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabbsbackend.domain.user.UserModel;
import com.javabbsbackend.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET, value="/user/{id}")
    public String find(@PathVariable("id") Integer id) {
        List<UserModel> user = userService.find(id);
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public void entry(@RequestBody UserModel user) {
        userService.entry(user);
    }

    @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserModel user) {
        userService.update(user);
    }

    @DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody UserModel user) {
        userService.delete(user);
    }
}
