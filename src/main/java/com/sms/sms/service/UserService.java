package com.sms.sms.service;

import com.sms.sms.dto.UserDTO;
import com.sms.sms.entity.User;
import com.sms.sms.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper .map(userDTO, User.class));
        return userDTO;
    }
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper .map(userDTO, User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper .map(userDTO, User.class));
        return true;
    }
    public UserDTO getUserByUserID(String UserId){
        User user = userRepo.getUserByUserID(UserId);
        return modelMapper.map(user,UserDTO.class);
    }
    public UserDTO getUserByUserIDAndFaculty(String userId, String faculty){
        User user = userRepo.getUserByUserIDAndFaculty(userId,faculty);
        return modelMapper.map(user,UserDTO.class);
    }



}