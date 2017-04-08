package model;

/**
 * Created by anh hoang anh on 4/8/2017.
 */

public class User {
    private String userName;
    private String PassWord;


    public User(String userName, String passWord) {
        this.userName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return PassWord;
    }
}
