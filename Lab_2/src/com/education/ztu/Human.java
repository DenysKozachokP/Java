package com.education.ztu;

public interface Human {

    public void sayAge();
    public void sayGender();
    public void sayLocation();
    public void sayName();
    default void whoIAm(){
        System.out.print("i am human");
    }
}

