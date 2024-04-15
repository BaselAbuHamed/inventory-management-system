package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    @Size(min = 10, max = 15)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Size(min = 10, max = 50)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 10)
    private String password;

}
