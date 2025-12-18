package model;

import exception.EntityAlreadyExistsException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Mentor extends  Instructor{
    private final Set<Instructor> subordinates = new HashSet<>();
    public Mentor(String id, String nome, LocalDate birthDate, Double courseRevenue, Mentor mentorInCharge) {
        super(id, nome, birthDate, courseRevenue, mentorInCharge);
    }

    @Override
    public double getCommission() {
        return ((double) 20 /100) *  getCourseRevenue() +
                subordinates.stream().mapToDouble(Instructor::getCommission).sum();
    }

    public void addSubordinate(Instructor instructor){
        if(subordinates.contains(instructor)){
            throw new EntityAlreadyExistsException("Subordinates already exists");
        }
        subordinates.add(instructor);
        System.out.println("Subordinates added");
    }

    public Set<Instructor> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Mentor: " + getId() + getNome() +
                "subordinates = " + "  " + subordinates.stream().map(Instructor::getNome).toList() +
                '}';
    }
}
