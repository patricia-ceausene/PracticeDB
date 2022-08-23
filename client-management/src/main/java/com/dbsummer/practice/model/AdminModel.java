package com.dbsummer.practice.model;

public class AdminModel {

    private int id;
    private String username;
    private String userRole;

    public AdminModel(){};



    public AdminModel(String username, String userRole) {
        this.username = username;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
