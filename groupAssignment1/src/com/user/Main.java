package com.user;
public class Main {
    public static void main(String[] args) {
        // User u1 = new User("John");
        // User u2 = new User(null);
        User u1 = new User("John");
        User u2 = new User("Billy");
        System.out.println(u1.equals(u2));

        // SpecialUser su1 = new SpecialUser(null, 1);
        // SpecialUser su2 = new SpecialUser("John", 1);
        SpecialUser su1 = new SpecialUser("John", 1);
        SpecialUser su2 = new SpecialUser("John", 1);
        System.out.println(su1.equals(su2));

        // System.out.println(su1.equals(u1));
    }
}