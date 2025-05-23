package org.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userCity")
    private String userCity;

    public User() {
    }

    public User(int userId, String userName, String userCity) {
        this.userId = userId;
        this.userName = userName;
        this.userCity = userCity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "User{ " +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCity='" + userCity + '\'' +
                " }";
    }
}
