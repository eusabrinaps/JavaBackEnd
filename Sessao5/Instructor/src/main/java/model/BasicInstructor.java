package model;

import java.time.LocalDate;

public final class BasicInstructor extends Instructor {
    public BasicInstructor(String id, String nome, LocalDate birthDate, Double courseRevenue,  Mentor mentorInCharge) {
        super(id, nome, birthDate, courseRevenue, mentorInCharge);
    }

    @Override
    public double getCommission() {
        return ((double) 20 /100) * getCourseRevenue();
    }

    @Override
    public String toString() {
        return "BasicInstructor: " + getNome();
    }
}
