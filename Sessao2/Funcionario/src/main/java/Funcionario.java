public class Funcionario {
    final private String nome;
    final private String matricula;
    final private String cargo;
    private double salario;
    private Departamento departamento;

    public Funcionario(String  nome, String matricula, String cargo, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void aumentarSalario(double percentual){
        if(percentual <= 0) return;

        salario = salario + (salario * percentual);
    }


    public String getNome() {
        return nome;
    }


    public String getMatricula() {
        return matricula;
    }


    public String getCargo() {
        return cargo;
    }


    public double getSalario() {
        return salario;
    }

    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }

    public String exibirDados(){
        return "Funcionário: " + nome + ", Departamento: " + departamento.getNome() + ", Cargo:" + cargo;
    }


}
