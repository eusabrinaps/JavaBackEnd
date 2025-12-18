public class Main {
    public static void main(String[] args) {
        Departamento recrutamento = new Departamento("Recursos Humanos", "RH", 10);
        Departamento tecnologia = new Departamento("Desenvolvimento", "TI", 5);

        Funcionario estagiario = new Funcionario("Rebeca", "2025", "Estágio RH", 1300);
        Funcionario JuniorTI = new Funcionario("Juan", "2024", "Back-End", 2000);

//        recrutamento.addFuncionario(estagiario);
//        estagiario.setDepartamento(recrutamento);
//
//        tecnologia.addFuncionario(JuniorTI);
//        JuniorTI.setDepartamento(tecnologia);
//
//        recrutamento.listarFuncionarios();
//        tecnologia.listarFuncionarios();
//
//
//        tecnologia.removeFuncionario(JuniorTI);
//        tecnologia.listarFuncionarios();

        System.out.println(recrutamento.getCodigo());
        System.out.println(tecnologia.getCodigo());
    }
}
