package org.spring.jpa;

import org.spring.dao.UserRepository;
import org.spring.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.spring")
@EnableJpaRepositories(basePackages = "org.spring.dao")
@EntityScan(basePackages = "org.spring.entities")
public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User();
        user.setUserName("Shreeyash");
        user.setUserCity("Bangalore");

        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

}
