package com.example.WatchListSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    //--------------------------------------------------------
    // PROPERTIES
    //--------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int    id = 0;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "avatar_id")
    private int    avatarId;

    @Column(name = "date_inscription")
    private Date date     = new Date();


    //--------------------------------------------------------
    // CONSTRUCTOR
    //--------------------------------------------------------
    public User() {

    }
    public User(String mail, String pwd, String nick,int avatarId){
        this.email    = mail;
        this.password = pwd;
        this.pseudo   = nick;
        this.avatarId = avatarId;
    }

    //--------------------------------------------------------
    // GETTERS
    //--------------------------------------------------------
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPseudo() {
        return pseudo;
    }
    public int getAvatarId() {
        return avatarId;
    }
    public Date getDate() {
        return date;
    }

    //--------------------------------------------------------
    // SETTERS
    //--------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        String out = "";
        out += this.id        + " ";
        out += this.pseudo    + " ";
        out += this.email     + " ";
        out += this.password  + " ";
        out += this.date      + " ";
        out += this.avatarId  + " ";
        return out;
    }
}
