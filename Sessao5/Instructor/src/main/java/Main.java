import model.Instructor;
import persistence.Repository;
import service.InMemoryInstructorRepository;
import service.InstructorRegistrationService;
import service.InstructorReportService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criar repositório e serviços
        Repository<String, Instructor> repository = new InMemoryInstructorRepository();
        InstructorRegistrationService registrationService = new InstructorRegistrationService(repository);
        InstructorReportService reportService = new InstructorReportService(repository);

        // Registrar dados de teste
        registrationService.register("111", "Barbara Liskov", LocalDate.parse("1939-11-07"), 12000.0, null);
        registrationService.register("222", "Niklaus Wirth", LocalDate.parse("1934-02-15"), 8000.0, "111");
        registrationService.register("333", "Bjarne Stroustrup", LocalDate.parse("1950-12-30"), 5000.0, "111");
        registrationService.register("444", "James Gosling", LocalDate.parse("1955-05-19"), 3000.0, "222");

        // Gerar relatório para Barbara (topo da hierarquia)
        String report = reportService.reportOf("111");
        System.out.println(report);

        // Exemplo: pegar mentor do Niklaus usando mentorId
        Instructor niklaus = repository.findById("222");
        Instructor mentorOfNiklaus = repository.findById(niklaus.getMentorInCharge().getId());
        System.out.println("\nMentor de Niklaus: " + mentorOfNiklaus.getNome());
    }
}