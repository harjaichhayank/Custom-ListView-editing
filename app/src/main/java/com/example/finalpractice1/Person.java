package com.example.finalpractice1;

public class Person implements Comparable<Person>{
    private String Name;
    private int Age;
    private int phoneNumber;

    Person(String name, int age, int phoneNumber) {
        Name = name;
        Age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Sorting
    @Override
    public int compareTo(Person other) {
        return this.Name.compareTo(other.Name);
    }
}
