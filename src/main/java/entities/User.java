/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lene_
 */
public class User {
    private String name;
    private String password;
    private int balance;
    private String email;

    public User(String name, String password, int balance, String email) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.email = email;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", balance=" + balance + ", email=" + email + '}';
    }
    
    
    
    
    
}
