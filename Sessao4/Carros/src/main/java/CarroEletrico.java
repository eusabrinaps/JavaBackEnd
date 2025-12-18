public final class CarroEletrico extends Veiculo{
    private final int capacidadeBateria;

    public CarroEletrico(String marca, String modelo,String cor, int ano, int capacidadeBateria){
        super(marca, modelo, cor, ano);
        this.capacidadeBateria = capacidadeBateria;

    }

    @Override
    public String getDescricao(){
        return "Carro Elétrico " + getMarca() + " " + getModelo() +
                " (" + getAno() + ", " + getCor() + "), " +
                capacidadeBateria + "cc.";
    }
}
