public abstract class Animal {
    String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract void fazerSom();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
