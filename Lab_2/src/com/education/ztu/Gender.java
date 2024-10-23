package com.education.ztu;

public enum Gender {
    MALE,
    FEMALE;

    Gender(){}

    public Gender valueOfGender(String name) {
        return Enum.valueOf(Gender.class, name);
    }

    public static Gender[] valuesGender() {
        return new Gender[]{ MALE,FEMALE};
    }
}
