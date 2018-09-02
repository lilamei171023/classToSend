package com.classroom.entity;

import java.io.Serializable;

public class ShiroUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;

    public ShiroUser(int id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
