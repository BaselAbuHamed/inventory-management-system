package edu.comp4382.inventorymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class InventoryManagementSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(InventoryManagementSystemApplication.class, args);

    }

}
