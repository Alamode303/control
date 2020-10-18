package com.exams.exam1;

import java.time.LocalDate;
import java.util.Objects;

public class Visitor {
    private String name;
    private String surName;

    private LocalDate birthDay;

    public Visitor(String name, String surName, LocalDate birthDay) {
        Objects.requireNonNull(name, "Неверное имя");
        Objects.requireNonNull(surName, "Неверная фамилия");
        Objects.requireNonNull(birthDay, "Неверная дата");
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name= '" + name + '\'' +
                ", surName= '" + surName + '\'' +
                '\'' +
                ", birthDay= " + birthDay +
                '}';
    }
}
