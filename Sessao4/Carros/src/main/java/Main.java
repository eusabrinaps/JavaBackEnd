public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Fiat", "Punto", "Preto", 2012, 4);
        Carro carro2 = new Carro("Fiat", "Fiesta", "Prata", 2015, 4);

        Moto moto1 = new Moto("Honda", "CG", "Vermelha", 2015, 150);
        Moto moto2 = new Moto("Yamaha", "Fazer", "Preto Fosco", 2022, 250);

        System.out.println(carro1.getDescricao());
        System.out.println(carro2.getDescricao());
        System.out.println(moto1.getDescricao());
        System.out.println(moto2.getDescricao());

    }
}
