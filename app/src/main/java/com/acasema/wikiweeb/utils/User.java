package com.acasema.wikiweeb.utils;

import android.net.Uri;

public class User {
    static String USER;
    static String PASSWORD;

    static {
        USER = "a";
        PASSWORD = "a";
    }

    public static String getUser() {
        return USER;
    }

    public static void setUser(String user) {
        USER = user;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static void setPassword(String password) {
        PASSWORD = password;
    }

}
