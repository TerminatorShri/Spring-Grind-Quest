package org.spring.dao;

import org.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByUserName(String userName);

    public List<User> findByUserNameAndUserCity(String userName, String userCity);

    public List<User> findUserByUserNameStartingWith(String userName);

    public List<User> findUserByUserNameEndingWith(String userName);

    public List<User> findUserByUserNameContaining(String userName);

    public List<User> findUserByUserNameIn(List<String> userNames);

    @Query("SELECT u FROM User u")
    public List<User> getAllUsers();

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findUserByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userName = ?1 AND u.userCity = ?2")
    public User findUserByUserNameAndUserCity(String userName, String userCity);

    @Query(value = "SELECT * FROM User WHERE userName LIKE %?1%", nativeQuery = true)
    public User findUserNameContaining(String userName);
}
