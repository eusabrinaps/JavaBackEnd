package model;

import java.util.ArrayList;
import java.util.List;

public final class DeclaracaoCompleta extends Declaracao {
    private final List<Gasto> gastos = new ArrayList<>();

    public DeclaracaoCompleta(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        double imposto = 0.0;
        double renda = getGanhoTributavel();

        if(renda > 55974.16){
            imposto += (renda - 55974.16) * 0.275;
            renda = 55974.16;
        }
        if(renda > 45012.73){
            imposto += (renda - 45012.73) * 0.225;
            renda = 45012.73;
        }
        if(renda > 33919.93){
            imposto += (renda - 33919.93) * 0.15;
            renda = 33919.93;
        }
        if(renda > 22847.88){
            imposto += (renda - 22847.88) * 0.075;
            renda = 22847.88;
        }
        return imposto;
    }

    @Override
    public double getDespesaDedutivel() {
        if(gastos.isEmpty()){return 0;}

        double valorSaude = 0.0;
        double valorEduca = 0.0;

        for(Gasto g : gastos){
            if(g instanceof GastoSaude){
                valorSaude += g.getValor();
            }
            else{
                valorEduca += g.getValor();
            }
        }
        return Math.min(valorSaude, GastoSaude.getDeducaoMaxSaude()) + Math.min(valorEduca, GastoEducacao.getDeducaoMaxEduca());
    }

    public void addGasto(Gasto g){
        gastos.add(g);
    }

    public void removeGasto(Gasto g){
        gastos.remove(g);
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    @Override
    public String toString() {
        return "Declaração Completa\n" +
                "Ganho Tributavel:R$ " + getGanhoTributavel() +
                "Valor Pago:R$" + getValorPago() + "\n " +
                "Valor Imposto:R$ "+ getValorImposto() + "\n" +
                "Valor A Pagar:R$ " + getValorAPagar();
    }

}
