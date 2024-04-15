package edu.comp4382.inventorymanagementsystem.repository;

import edu.comp4382.inventorymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
