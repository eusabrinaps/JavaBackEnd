package model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Instructor permits BasicInstructor, Mentor {
    private final String id;
    private final String nome;
    private final LocalDate birthDate;
    private final double courseRevenue;
    private final Mentor mentorInCharge;

    public Instructor(String id, String nome, LocalDate birthDate, Double courseRevenue,  Mentor mentorInCharge) {
        this.id = id;
        this.nome = nome;
        this.birthDate = birthDate;
        this.courseRevenue = courseRevenue;
        this.mentorInCharge = mentorInCharge;
    }

    public abstract double getCommission();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getCourseRevenue() {
        return courseRevenue;
    }

    public Mentor getMentorInCharge() {
        return mentorInCharge;
    }

}
