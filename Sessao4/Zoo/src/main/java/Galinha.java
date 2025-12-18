public class Galinha extends Animal implements Correr{
    public Galinha(String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        System.out.println("Có Có Có");
    }

    public void correr(){
        System.out.println("Galinha está correndo");
    }
}
