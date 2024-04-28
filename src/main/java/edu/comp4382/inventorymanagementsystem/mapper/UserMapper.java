package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.UserDto;
import edu.comp4382.inventorymanagementsystem.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }

    public static User mapToUser(UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword());
    }
}
