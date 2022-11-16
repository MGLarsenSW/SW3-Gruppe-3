package com.example.gr3.p3.classes;

// TODO: Implement this at a later stage of development

public class User {
    protected boolean loginStatus; // boolean (primitive type)
    public String username;
    private String password;

    public User(String username, String password) {
        this.loginStatus = false;
        this.username = username;
        this.password = password;
    }

    // TODO: Only for testing currently
    public boolean verifyLogin(){
        if(this.username == "admin" && this.password == "admin"){
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public String getUsername() {
        return username;
    }
}
