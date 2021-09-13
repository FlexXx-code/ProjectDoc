package com.example.projectdoc;

public class UserHelperClass {

    public UserHelperClass() {

    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    String fullNames,password,mail;

    public UserHelperClass(String fullNames, String password, String mail) {
        this.fullNames = fullNames;
        this.password = password;
        this.mail = mail;
    }




}

