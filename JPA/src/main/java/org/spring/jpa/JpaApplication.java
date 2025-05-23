package org.spring.jpa;

import org.spring.dao.UserRepository;
import org.spring.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = "org.spring")
@EnableJpaRepositories(basePackages = "org.spring.dao")
@EntityScan(basePackages = "org.spring.entities")
public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        // Create a new user
        // User user1 = new User();
        // user.setUserName("Shreeyash");
        /// user.setUserCity("Bangalore");
        // User savedUser1 = userRepository.save(user1);
        // System.out.println(savedUser1);

        // User user2 = new User("Shreeyash Dongarkar", "Bangalore");
        // List<User> users = List.of(user1, user2);

        // Save multiple users
        // List<User> savedUsers = userRepository.saveAll(users);

        // Read all users
        // Iterable<User> users = userRepository.findAll();

        // for (User user : users) {
        //     System.out.println(user);
        // }

        // Update a user
        // User userToUpdate = userRepository.findById(1).orElse(null);

        // if (userToUpdate != null) {
        //     userToUpdate.setUserCity("Pune");
        //     userRepository.save(userToUpdate);
        // }

        // Delete a user
        // User userToDelete = userRepository.findById(2).orElse(null);

        // if (userToDelete != null) {
        //     userRepository.delete(userToDelete);
        //     System.out.println("User deleted successfully");
        // }

        List<User> selectedUsers = userRepository.findByUserNameAndUserCity("Shreeyash", "Bangalore");

        for (User user : selectedUsers) {
            System.out.println(user);
        }

        List<User> selectedUsers2 = userRepository.findUserByUserNameStartingWith("Shree");

        for (User user : selectedUsers2) {
            System.out.println(user);
        }
    }

}
