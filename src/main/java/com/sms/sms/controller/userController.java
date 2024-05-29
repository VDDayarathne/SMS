package com.sms.sms.controller;

import com.sms.sms.dto.UserDTO;
import com.sms.sms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin

public class userController {
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "User Updated";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User Deleted";
    }

}
