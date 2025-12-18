package model;

public final class DeclaracaoSimplificada extends Declaracao {
    private final static double ISENCAO = 22847.88;
    private final static double TAXA = 0.20;

    public DeclaracaoSimplificada(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        double ultrapassado = ISENCAO - getGanhoTributavel();
        return ultrapassado <=0 ? 0.0 : ultrapassado * TAXA;
    }

    @Override
    public double getDespesaDedutivel() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Declaracao Simplificada" +
                "Valor Imposto: " + getValorImposto() +
                "Valor a Pagar: " + getValorAPagar();
    }

}
