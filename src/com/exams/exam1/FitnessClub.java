package com.exams.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class FitnessClub {
    private GymMembership gymMembership;
    private String option;
    private LocalDate presentDay;
    private LocalTime presentTime;
    private GymMembership[] sweem = new GymMembership[20];
    private GymMembership[] gym = new GymMembership[20];
    private GymMembership[] group = new GymMembership[20];


    public FitnessClub(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate);
        Objects.requireNonNull(localTime);
        setPresentTime(localDate, localTime);

    }


    private int gymVisitors = 0;
    private int swimmingVisitors = 0;
    private int groupVisitors = 0;

    public void visitorRegistration(GymMembership gymMembership, Option option) {
        Objects.requireNonNull(gymMembership);
        Objects.requireNonNull(option);
        if (gymMembershipDateChek(gymMembership) && gymMembershipTimeOptionChek(gymMembership, option)) {
            switch (option) {
                case GYM:
                    if (isGroupReg(gymMembership)) {
                        leaveGroup(gymMembership);
                    }
                    if (isSwimmingReg(gymMembership)) {
                        leaveSwim(gymMembership);
                    }
                    if (gymVisitors <= 20 && !isGymReg(gymMembership)) {
                        for (int i = 0; i < gym.length; i++) {
                            if (gym[i] == null) {
                                gym[i] = gymMembership;
                                gymVisitors++;
                                System.out.println("Вы прошли в зал");
                                Logger.visitorInfo(gymMembership, option, presentDay, presentTime);
                                break;
                            }
                        }
                    } else System.out.println("Зал переполнен, или вы уже прошли");
                    break;

                case SWIMMING:
                    if (isGroupReg(gymMembership)) {
                        leaveGroup(gymMembership);
                    }
                    if (isGymReg(gymMembership)) {
                        leaveGym(gymMembership);
                    }
                    if (swimmingVisitors <= 20 && !isSwimmingReg(gymMembership)) {
                        for (int i = 0; i < sweem.length; i++) {
                            if (sweem[i] == null) {
                                sweem[i] = gymMembership;
                                swimmingVisitors++;
                                System.out.println("Вы прошли в бассейн");
                                Logger.visitorInfo(gymMembership, option, presentDay, presentTime);
                                break;
                            }
                        }
                    } else System.out.println("Зал переполнен, или вы уже прошли");
                    break;

                case GROUP:
                    if (isSwimmingReg(gymMembership)) {
                        leaveSwim(gymMembership);
                    }
                    if (isGymReg(gymMembership)) {
                        leaveGym(gymMembership);
                    }
                    if (groupVisitors <= 20 && !isGroupReg(gymMembership)) {
                        for (int i = 0; i < group.length; i++) {
                            if (group[i] == null) {
                                group[i] = gymMembership;
                                groupVisitors++;
                                System.out.println("Вы прошли на групповые занятия");
                                Logger.visitorInfo(gymMembership, option, presentDay, presentTime);
                                break;
                            }
                        }
                    } else System.out.println("Зал переполнен, или вы уже прошли");
                    break;
            }
        }
    }

    public void optionFullStat() {
        System.out.println("            Все посетители");
        System.out.println("В зале: ");
        int j = 0;


        for (int i = 0; i < gym.length; i++) {
            if (gym[i] != null) {
                j++;
                System.out.print(j + ") ");
                Logger.visitorData(gym[i].getVisitor());
            }
        }

        System.out.println("__________________");
        System.out.println("В бассейне: ");
        int s = 0;
        for (int i = 0; i < sweem.length; i++) {
            if (sweem[i] != null) {
                s++;
                System.out.print(s + ") ");
                Logger.visitorData(sweem[i].getVisitor());
            }
        }


        System.out.println("__________________");
        System.out.println("На групповых занятиях: ");
        int k = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null) {
                k++;
                System.out.print(k + ") ");
                Logger.visitorData(group[i].getVisitor());
            }
        }

        System.out.println("__________________");
    }

    public void optionStat() {
        System.out.println("Всего посетителей: \n в зале " + gymVisitors + "\n в бассейне " + swimmingVisitors + "\n в группе " + groupVisitors);
    }

    public void setPresentTime(LocalDate presentDay, LocalTime presentTime) {
        Objects.requireNonNull(presentDay);
        Objects.requireNonNull(presentTime);
        this.presentDay = presentDay;
        this.presentTime = presentTime;
        System.out.println("Новые дата и время");
        LocalTime dayTime = LocalTime.of(16, 0);
        LocalTime closeTime = LocalTime.of(22, 0);

        if (presentTime.isAfter(closeTime)) {
            timeToClose();
        }
        if (presentTime.isAfter(dayTime)) {
            timeToDayLeave();
        }

    }

    public boolean isGymReg(GymMembership gymMembership) {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] == gymMembership) return true;
        }
        return false;
    }

    public boolean isSwimmingReg(GymMembership gymMembership) {
        for (int i = 0; i < sweem.length; i++) {
            if (sweem[i] == gymMembership) return true;
        }
        return false;
    }

    public boolean isGroupReg(GymMembership gymMembership) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == gymMembership) return true;
        }
        return false;
    }

    public boolean gymMembershipDateChek(GymMembership gymMembership) {
        if (presentDay.isBefore(gymMembership.endDayOfRegistration) && presentDay.isAfter(gymMembership.startDayOfRegistration))
            return true;
        else {
            System.out.println("Абонемент просрочен!!!");
            return false;
        }
    }

    public boolean gymMembershipTimeOptionChek(GymMembership gymMembership, Option option) {
        LocalTime openTime = LocalTime.of(8, 0);
        LocalTime closeTime = LocalTime.of(22, 0);
        LocalTime dayCloseTime = LocalTime.of(16, 0);
        if (gymMembership.getType() == Type.DAY) closeTime = dayCloseTime;
        if (openTime.isBefore(presentTime) && closeTime.isAfter(presentTime)) {
            if (gymMembership.getType() == Type.FULL) return true;
            else if (gymMembership.getType() == Type.SINGLE && option != Option.GROUP) return true;
            else if (gymMembership.getType() == Type.DAY && option != Option.SWIMMING) return true;
            else System.out.println("Вам не доступны занятия " + option.name() + "\nпопробуйте выбрать другую");


        } else System.out.println("Недоступное время посещения");
        return false;

    }

    public void leaveGym(GymMembership gymMembership) {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] == gymMembership) {
                gym[i] = null;
                gymVisitors--;
            }
        }
    }

    public void leaveGroup(GymMembership gymMembership) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == gymMembership) {
                group[i] = null;
                groupVisitors--;
            }
        }
    }

    public void leaveSwim(GymMembership gymMembership) {
        for (int i = 0; i < sweem.length; i++) {
            if (sweem[i] == gymMembership) {
                sweem[i] = null;
                swimmingVisitors--;
            }
        }
    }

    public void timeToClose() {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] != null) {
                gym[i] = null;
                gymVisitors--;
            }
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null) {
                group[i] = null;
                groupVisitors--;
            }
        }
        for (int i = 0; i < sweem.length; i++) {
            if (sweem[i] != null) {
                sweem[i] = null;
                swimmingVisitors--;
            }
        }
    }

    public void timeToDayLeave() {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] != null && gym[i].getType() == Type.DAY) {
                gym[i] = null;
                gymVisitors--;
            }
        }
        for (int i = 0; i < sweem.length; i++) {
            if (sweem[i] != null && sweem[i].getType() == Type.DAY) {
                sweem[i] = null;
                swimmingVisitors--;
            }
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && group[i].getType() == Type.DAY) {
                group[i] = null;
                groupVisitors--;
            }
        }
    }

}
