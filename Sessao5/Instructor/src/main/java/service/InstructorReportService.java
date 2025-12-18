package service;

import model.Instructor;
import model.Mentor;
import persistence.Repository;

public class InstructorReportService {
    private InMemoryInstructorRepository repository;
    public InstructorReportService(InMemoryInstructorRepository repository) {
        this.repository = repository;
    }

    /*
    Retorna uma String com dados e comissão do instrutor e todos sob sua supervisão.
     */
    public String reportOf(String id){
        if(id != null){
            if(repository.getDataBase().containsKey(id)){
                Instructor instructor = repository.getDataBase().get(id);
                StringBuilder sb = new StringBuilder();
                sb.append(instructor.toString()).append("\n");
                if(instructor instanceof Mentor){
                    ((Mentor) instructor).getSubordinates().forEach((subordinate) -> {
                        sb.append(reportOf(subordinate.getId()));
                    });
                    return sb.toString();
                }
                return sb.toString();
            }
        }
        return "Id não encontrado no banco";
    }
}
