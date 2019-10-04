package org.bevylabs.locationshare;

public class User {
    private String login_email;
    private String login_password;

    public String getLogin_email() {
        return login_email;
    }

    public void setLogin_email(String email) {
        this.login_email = login_email;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String password) {
        this.login_password = login_password;
    }

    public User(String login_email, String login_password){
        this.login_email = login_email;
        this.login_password = login_password;
    }
    public  User(){

    }

}


