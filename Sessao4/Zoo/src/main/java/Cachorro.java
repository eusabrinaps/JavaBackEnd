public class Cachorro extends Animal implements Correr {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        System.out.println("Au Au Au");
    }

    public void correr() {
        System.out.println("Cachorro está correndo");
    }


}
