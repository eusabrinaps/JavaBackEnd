package service;

import model.Consultant;
import model.Employee;
import model.InMemoryEmployeeRepository;
import model.Reseller;
import persistence.Repositoty;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final InMemoryEmployeeRepository repositoty;

    public EmployeeRegistrationService(InMemoryEmployeeRepository repositoty) {
        this.repositoty = repositoty;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String idConsultant){
        if(id != null && name != null && birthDate != null && soldValue > 0 && idConsultant != null){
            Employee consultor = repositoty.getDataBase().get(idConsultant);

            if(consultor != null){
               if(consultor instanceof Reseller){
                   Consultant promovido = new Consultant(consultor.getId(), consultor.getName(), consultor.getBirthDate(),
                           consultor.getSoldValue(), consultor.getConsultantInCharge());
                   repositoty.save(promovido);
                   consultor =  promovido;
               }
               Consultant consultant = (Consultant) consultor;
               Reseller reseller = new Reseller(id, name, birthDate, soldValue, consultant);
            }
        }
        System.out.println("Erro de inserção");
    }
}
