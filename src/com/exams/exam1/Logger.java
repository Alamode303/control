package com.exams.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Logger {


    public static void visitorInfo(GymMembership gymMembership, Option option, LocalDate date, LocalTime time){
        Objects.requireNonNull(gymMembership);
        Objects.requireNonNull(option);
        Objects.requireNonNull(date);
        Objects.requireNonNull(time);
        System.out.println("********************");
        System.out.println("Фамилия: " + gymMembership.getVisitor().getSurName());
        System.out.println("Имя: " + gymMembership.getVisitor().getName());
        switch (option){
            case GYM:
                System.out.println("Зона: Зал");
                break;
            case SWIMMING:
                System.out.println("Зона: Бассейн");
                break;
            case GROUP:
                System.out.println("Зона: Групповые занятия");
                break;
        }
        System.out.println("Дата и время посещения: " + date + " "+ time);
        System.out.println("********************");
    }
    public static void visitorData(Visitor visitor){
        System.out.println("Фамилия: " + visitor.getSurName() + " ||  Имя: " + visitor.getName() + " ||  День рождения: " + visitor.getBirthDay());
    }
}
