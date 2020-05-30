package com.example.finalpractice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFriends {

    private List<Person> myFriendsList;

    public MyFriends(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }

    MyFriends(){
        String[] names = {"Aisha","Bart","Catalan","Dines"};
        Random random = new Random();
        this.myFriendsList = new ArrayList<>();

        for (String name : names) {
            Person person = new Person(name, random.nextInt(50) + 15, random.nextInt(20) + 5);
            myFriendsList.add(person);
        }
    }

    List<Person> getMyFriendsList() {
        return myFriendsList;
    }

    public void setMyFriendsList(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }
}
