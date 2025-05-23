package org.spring.dao;

import org.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByUserName(String userName);
    public List<User> findByUserNameAndUserCity(String userName, String userCity);
    public List<User> findUserByUserNameStartingWith(String userName);
    public List<User> findUserByUserNameEndingWith(String userName);
    public List<User> findUserByUserNameContaining(String userName);
    public List<User> findUserByUserNameIn(List<String> userNames);
}
