package com.user;
public class User {
    private String name;
    public User(String name){this.name = name;}
    @Override public boolean equals(Object obj) {
        if(!(obj instanceof User)) return false; // edge case: if obj is not a subclass of User, return false
        return ((User)obj).name.equals(this.name); // cast obj to User and compare names
    }
}    