package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.UserDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long id ,UserDto userDto);

    void deleteUser(Long id);
}
