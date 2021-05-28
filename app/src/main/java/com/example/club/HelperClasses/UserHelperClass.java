package com.example.club.HelperClasses;

public class UserHelperClass {
    String fullname, email ,username, password, date , type , phoneNo;

    public UserHelperClass(String fullname, String email, String username, String password, String date, String tyoe, String phoneNo) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.date = date;
        this.type = type;
        this.phoneNo = phoneNo;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getPhoneNo() {
        return phoneNo;

    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}

