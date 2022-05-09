package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> showAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> UserDtoList = new ArrayList<>();
        for (User user : users) {
            UserDtoList.add(UserMapper.INSTANCE.toDto(user));
        }
        return UserDtoList;
    }

    public UserDto saveUser(User user) {
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    public String updateUser(UUID id, String name) {
        Optional<User> temp_user = userRepository.findById(id);
        if(temp_user.isEmpty()) {
            return "Not found";
        }
        User user = temp_user.get();
        user.setName(name);
        userRepository.save(user);
        return "Name set";
    }

    public String deleteUser(UUID id) {
        userRepository.deleteById(id);
        return "Book has been deleted";
    }
}
