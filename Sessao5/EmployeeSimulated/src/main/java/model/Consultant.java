package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinates =  new HashSet<>();


    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
    }

    public void addSubordinate(Employee subordinate) {
        subordinates.add(subordinate);
    }

    @Override
    public double getComission() {
        return  0.15 * getSoldValue();
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }
}
