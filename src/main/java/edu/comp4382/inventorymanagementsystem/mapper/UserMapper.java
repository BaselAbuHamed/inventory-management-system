package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.UserDto;
import edu.comp4382.inventorymanagementsystem.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto (User user){
        return new UserDto(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }

    public static User mapToUser (UserDto userDto){
        return new User(userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword());
    }
}