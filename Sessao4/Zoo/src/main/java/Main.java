public class Main {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        Animal dog = new Cachorro("Rex");
        zoo.addAnimaisJaula(dog);
        zoo.assustandoAnimais();
    }
}
