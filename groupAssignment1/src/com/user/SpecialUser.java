package com.user;
public class SpecialUser extends User {
    private int id;
    public SpecialUser(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SpecialUser)) return false; // edge case: if obj is not a SpecialUser, return false
        return super.equals(obj) && ((SpecialUser)obj).id == this.id; // check that obj is a subclass of User and also compare ids
    }

}