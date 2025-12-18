public class Cobra extends Animal{
    public Cobra(String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        System.out.println("som de cobra");
    }
}
