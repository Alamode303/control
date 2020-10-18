package com.exams.exam1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aplication {
    public static void main(String[] args) {
        Visitor visitor1 = new Visitor("Ваня", "Иванов", LocalDate.of(1996, 1, 17));
        Visitor visitor2 = new Visitor("Аня", "Петрова", LocalDate.of(1995, 7, 12));
        Visitor visitor3 = new Visitor("Таня", "Содорова", LocalDate.of(1987, 8, 11));
        Visitor visitor4 = new Visitor("Саша", "Измайлов", LocalDate.of(1967, 4, 25));
        Visitor visitor5 = new Visitor("Никита", "Титорчук", LocalDate.of(1985, 3, 29));
        Visitor visitor6 = new Visitor("Вова", "Щербак", LocalDate.of(1999, 2, 10));
        Visitor visitor7 = new Visitor("Сеня", "Просин", LocalDate.of(1902, 3, 15));

        GymMembership gymMembership1 = new GymMembership(visitor1, Type.DAY, LocalDate.of(2020,6,12), LocalDate.of(2021,6,12));
        GymMembership gymMembership2 = new GymMembership(visitor2, Type.FULL, LocalDate.of(2020,6,12), LocalDate.of(2021,6,12));
        GymMembership gymMembership3 = new GymMembership(visitor3, Type.DAY, LocalDate.of(2020,6,12), LocalDate.of(2021,6,12));
        GymMembership gymMembership4 = new GymMembership(visitor4, Type.SINGLE, LocalDate.of(2020,6,12), LocalDate.of(2020,6,14));
        GymMembership gymMembership5 = new GymMembership(visitor5, Type.DAY, LocalDate.of(2020,6,12), LocalDate.of(2021,6,12));
        GymMembership gymMembership6 = new GymMembership(visitor6, Type.FULL, LocalDate.of(2018,6,12), LocalDate.of(2019,6,12));
        GymMembership gymMembership7 = new GymMembership(visitor6, Type.FULL, LocalDate.of(2020,6,12), LocalDate.of(2022,6,12));

        FitnessClub fitnessClub = new FitnessClub(LocalDate.of(2020,6,13), LocalTime.of(15,30));
        fitnessClub.visitorRegistration(gymMembership1, Option.SWIMMING);
        fitnessClub.visitorRegistration(gymMembership1, Option.GROUP);
        fitnessClub.visitorRegistration(gymMembership1, Option.GYM);
        fitnessClub.visitorRegistration(gymMembership2, Option.GROUP);
        fitnessClub.visitorRegistration(gymMembership3, Option.GYM);
        fitnessClub.visitorRegistration(gymMembership4, Option.SWIMMING);
        fitnessClub.visitorRegistration(gymMembership5, Option.GYM);
        fitnessClub.visitorRegistration(gymMembership6, Option.GROUP);
        fitnessClub.optionFullStat();
        fitnessClub.optionStat();

        fitnessClub.setPresentTime(LocalDate.of(2020,6,13), LocalTime.of(16,02));

        fitnessClub.optionStat();
        fitnessClub.visitorRegistration(gymMembership1, Option.GROUP);
        fitnessClub.visitorRegistration(gymMembership2, Option.GROUP);

        fitnessClub.setPresentTime(LocalDate.of(2020,6,13), LocalTime.of(22,01));
        fitnessClub.optionStat();

    }
}
