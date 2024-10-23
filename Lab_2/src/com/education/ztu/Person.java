package com.education.ztu;

public class Person implements Human {
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private Location location;


    public Person() {
        this.firstname = "Den";
        this.lastname = "KZC";
        this.age = 20;
        this.gender = Gender.MALE;
        this.location = Location.ZHYTOMYR;
    }

    public void getFullInfo() {
        System.out.println(firstname + " " + lastname + ", " + age + " років, " + gender + ", " + location);
    }

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }


    public String getFirstname()
    {
        return firstname;
    }
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public Gender getGender()
    {
        return gender;
    }
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Location getLocation()
    {
        return location;
    }
    public void setLocation(Location location)
    {
        this.location = location;
    }
    public void getOccupation(){

    }
    @Override
    public void sayName() {
        System.out.println("Ім'я: " + this.firstname);
    }
    @Override
    public void sayAge() {
        System.out.println("Вік: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Локація: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Стать: " + gender);
    }
}
