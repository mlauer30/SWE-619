package com.discussion1;
import java.util.HashMap;
public class Login {
    static boolean allowLogin(String user, String pwd){
        boolean loggedIn=true;
        try{
            String realPwd = getRealPwdFromDb(user);
            if(!pwd.equals(realPwd)){
                loggedIn = false;
            }
        }catch(Exception e){
            System.out.println("This cannot happen, ignore...");
            throw new IllegalArgumentException();
        }
        return loggedIn;
    }
    static String getRealPwdFromDb(String user){
        HashMap<String, String> db = new HashMap<String, String>();
        db.put("user1", "123456789greatpwd!");
        db.put("user2", "123456789greatpwd!");
        db.put("user3", "123456789greatpwd!");
        db.put("user4", "123456789greatpwd!");
        db.put("user5", "123456789greatpwd!");
        return db.get(user);
    }
    public static void main(String[] args) {
        // String pwd = "badData";
        String pwd = getRealPwdFromDb("user1");
        if(allowLogin("user1", pwd)){
            System.out.println("Login successful");
        }else{
            System.out.println("Login failed");
        }
                
    }
}
