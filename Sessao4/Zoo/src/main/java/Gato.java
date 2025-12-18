public class Gato extends Animal implements Correr{
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void fazerSom() {
        System.out.println("Miau Miau");
    }

    public void correr(){
        System.out.println("Gato está Correndo");
    }


}
