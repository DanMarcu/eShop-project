/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    @Column (name="username")
    private String username;
    @Column (name="password")
    private String password;
    @Column (name="email")
    private String email;
    @Column (name="first_name")
    private String firstName;
    @Column (name="last_name")
    private String lastName;
    @Column (name="city")
    private String city;
    @Column (name="uuid")
    private String uuid;
 
    
    ////////////////////
    /// CONSTRUCTORS ///
    ////////////////////

    public User(int id, String username, String password, String email, String firstName, String lastName, String city) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCity(city);
    }
    
    public User(int id, String username, String email, String firstName, String lastName, String city) {
        this.setId(id);
        this.setUsername(username);
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCity(city);
    }
    
    public User(String username, String password, String email, String firstName, String lastName, String city, String uuid) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCity(city);
        this.setUuid(uuid);
    }
    
    
    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
    
    public User() {    
    }
    
    
    ///////////////////////////
    /// GETTERS AND SETTERS ///
    ///////////////////////////

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
