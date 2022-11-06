package models;

import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String username;
    private String password;
    private String email;
    private String rights;

    public Account(String name, String username, String password, String email, String rights) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rights = rights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        return "Account{" +
               "name='" + name + '\'' +
               ", usename='" + username + '\'' +
               ", password='" + password + '\'' +
               ", email='" + email + '\'' +
               ", rights='" + rights + '\'' +
               '}';
    }
}
