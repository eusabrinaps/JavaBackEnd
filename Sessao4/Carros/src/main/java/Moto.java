public final class Moto extends Veiculo {
    private final int capacidade;

    public Moto(String marca, String modelo, String cor,int ano, int capacidade){
        super(marca,modelo,cor,ano);
        this.capacidade = capacidade;
    }

    @Override
    public String getDescricao(){
        return "Moto " + getMarca() + " " + getModelo() +
                " (" + getAno() + ", " + getCor() + "), " +
                capacidade + "cc.";
    }
}
