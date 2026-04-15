package models.dto;

import models.User;

public class UserDto {
    // Atributos
    private String title;
    private User user;
    
    // Getters ^Setters
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
