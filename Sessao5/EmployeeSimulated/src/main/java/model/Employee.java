package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits Reseller,Consultant {
    private String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;
    private Consultant consultantInCharge;

    public Employee(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInCharge = consultantInCharge;
    }

    public abstract double getComission();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", soldValue=" + soldValue +
                ", consultantInCharge=" + consultantInCharge +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public Consultant getConsultantInCharge() {
        return consultantInCharge;
    }
}

