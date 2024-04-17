package edu.comp4382.inventorymanagementsystem.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long userId;
    @Length(min = 10, max = 15)
    private String username;
    private String email;
    @Length(min = 10)
    private String password;
}
