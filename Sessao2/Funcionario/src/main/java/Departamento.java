public class Departamento {
    final private String nome;
    final private String codigo;
    private Funcionario[] funcionarios;
    private int quantidadeFunc;

    public Departamento(String nome, String codigo, int capacidadeFuncionario) {
        this.nome = nome;
        this.codigo = codigo;
        this.funcionarios = new Funcionario[capacidadeFuncionario];
        this.quantidadeFunc = 0;
    }

    public void addFuncionario(Funcionario funcionario) {
        if(funcionario == null) return;

        for(Funcionario f : funcionarios){
            if(f!= null && f.getNome().equals(funcionario.getNome())){return;}
        }

        funcionarios[quantidadeFunc] = funcionario;
        quantidadeFunc++;
    }


    public void removeFuncionario(Funcionario funcionario) {
        if(funcionario == null) return;

        for (int i = 0; i <quantidadeFunc ; i++){
            if(funcionarios[i] == funcionario){
                for(int j = i; j < quantidadeFunc; j++){
                    funcionarios[j] = funcionarios[j+1];
                }
            }

            funcionarios[quantidadeFunc-1] = null;
            quantidadeFunc--;

        }
    }


    public String getNome() {
        return nome;
    }


    public String getCodigo() {
        return codigo;
    }



    public void listarFuncionarios() {
        if(quantidadeFunc <= 0) return;
        System.out.println("Funcionários do departamento " + nome + ":");
        for (int i = 0; i < quantidadeFunc; i++) {
            System.out.println(funcionarios[i].exibirDados());
        }
    }
}
