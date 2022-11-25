package com.aau.gr3.classes;

// TODO: Implement this at a later stage of development

import java.util.Objects;

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
    public void verifyLogin(){
        if(Objects.equals(this.username, "admin") && Objects.equals(this.password, "admin")){
            setLoginStatus(true);
        } else {
            setLoginStatus(false);
        }
    }
    private void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}
