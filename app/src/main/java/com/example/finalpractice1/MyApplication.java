package com.example.finalpractice1;

import android.app.Application;

public class MyApplication extends Application {
    private MyFriends myFriends = new MyFriends();

    public MyFriends getMyFriends() {
        return myFriends;
    }

    public void setMyFriends(MyFriends myFriends) {
        this.myFriends = myFriends;
    }
}
