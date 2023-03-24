package dao;

import java.util.Scanner;

public class User {
    private String name;
    private String surnames;
    private String username;
    private String email;
    private String password;

    public User(){
        System.out.print("Name: ");
        name=new Scanner(System.in).nextLine();

        System.out.print("Surnames: ");
        surnames=new Scanner(System.in).nextLine();

        System.out.print("Username: ");
        username=new Scanner(System.in).nextLine();

        System.out.print("email: ");
        email=new Scanner(System.in).nextLine();

        System.out.print("password: ");
        password=new Scanner(System.in).nextLine();
    }
    public User(String name, String surnames, String username, String email, String password) {
        this.name = name;
        this.surnames = surnames;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
