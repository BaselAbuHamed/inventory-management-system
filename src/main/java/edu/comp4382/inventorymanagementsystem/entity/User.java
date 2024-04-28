package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", unique = true, nullable = false)
    @Size(min = 5, max = 15, message = "Username length must be between 5 and 15 characters")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Size(min = 10, max = 50, message = "Email length must be between 10 and 50 characters")
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
