package service;

import model.BasicInstructor;
import model.Instructor;
import model.Mentor;
import persistence.Repository;

import java.time.LocalDate;

public class InstructorRegistrationService {
    private final InMemoryInstructorRepository repository;

    public InstructorRegistrationService(InMemoryInstructorRepository repository) {
        this.repository = repository;
    }

    public void register(String id, String nome, LocalDate birthDate, double courseRevenue, String idMentor) {
        if(!repository.getDataBase().containsKey(id)){
            if (idMentor == null) {
                Instructor newBasicInstructor = new BasicInstructor(id, nome, birthDate, courseRevenue, null);
                repository.save(newBasicInstructor);
                return;
            }

            Instructor mentor = repository.getDataBase().get(idMentor);
            if(mentor instanceof BasicInstructor){
                Mentor mentorPromoved = new Mentor(mentor.getId(), mentor.getNome(), mentor.getBirthDate(),
                        mentor.getCourseRevenue(), mentor.getMentorInCharge());
                repository.getDataBase().put(mentor.getId(), mentorPromoved);
                mentor = mentorPromoved;
            }
            Instructor newBasicInstructor = new BasicInstructor(id, nome, birthDate, courseRevenue, (Mentor) mentor);
            ((Mentor) mentor).addSubordinate(newBasicInstructor);
            repository.save(newBasicInstructor);

        }
    }
}
