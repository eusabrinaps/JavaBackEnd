public final class Carro extends Veiculo {
    private final int portas;

    public Carro(String marca, String modelo,String cor, int ano, int portas) {
        super(marca, modelo, cor, ano);
        this.portas = portas;
    }

    @Override
    public String getDescricao(){
        return "Carro " + getMarca() + " " + getModelo() +
                " (" + getAno() + ", " + getCor() + "), " +
                portas + " portas.";
    }
}
