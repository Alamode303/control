package com.exams.exam1;

import java.time.LocalDate;
import java.util.Objects;

public class GymMembership {
    protected Type type;
    protected Visitor visitor;
    protected LocalDate startDayOfRegistration;
    protected LocalDate endDayOfRegistration;


    public GymMembership(Visitor visitor,
                         Type type,
                         LocalDate startDayOfRegistration,
                         LocalDate endDayOfRegistration) {
        Objects.requireNonNull(visitor);
        Objects.requireNonNull(type);
        Objects.requireNonNull(startDayOfRegistration);
        Objects.requireNonNull(endDayOfRegistration);

        if (startDayOfRegistration.isAfter(endDayOfRegistration))
            throw new IllegalArgumentException("Неверные даты (начало егистрации позже окончания)");
        this.visitor = visitor;
        this.type = type;
        this.startDayOfRegistration = startDayOfRegistration;
        this.endDayOfRegistration = endDayOfRegistration;

    }


    public Type getType() {
        return type;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public LocalDate getStartDayOfRegistration() {
        return startDayOfRegistration;
    }

    public LocalDate getEndDayOfRegistration() {
        return endDayOfRegistration;
    }

    @Override
    public String toString() {
        return "GymMembership{" +
                "type='" + type + '\'' +
                ", startDayOfRegistration=" + startDayOfRegistration +
                ", endDayOfRegistration=" + endDayOfRegistration +
                ", visitor=" + visitor +
                '}';
    }
}
