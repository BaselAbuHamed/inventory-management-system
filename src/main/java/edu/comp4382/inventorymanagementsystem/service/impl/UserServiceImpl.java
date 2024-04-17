package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.UserDto;
import edu.comp4382.inventorymanagementsystem.entity.User;
import edu.comp4382.inventorymanagementsystem.mapper.UserMapper;
import edu.comp4382.inventorymanagementsystem.repository.UserRepository;
import edu.comp4382.inventorymanagementsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with given id : " + id));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = new ArrayList<>();
        for (User user : users) {
            userDto.add(UserMapper.mapToUserDto(user));
        }
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with given id : " + id));

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public UserDto patchUser(Long id, UserDto userDto) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with given id : " + id));

        // Update only the non-null fields from the userDto
        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }

        User updatedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }


    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with given id : " + id));

        userRepository.deleteById(id);
    }
}
