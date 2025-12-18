package model;

import repository.Entidade;

public sealed abstract class Declaracao implements Entidade<Integer> permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private int id;
    private final double ganhoTributavel;
    private final double valorPago;

    public Declaracao(double ganhoTributavel, double valorPago) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }
    public double getGanhoTributavel() {
        return ganhoTributavel;
    }
    public double getValorPago() {
        return valorPago;
    }

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public abstract double getDespesaDedutivel();
    public abstract double getValorImposto();
}
