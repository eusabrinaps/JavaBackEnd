package model;

public final class GastoEducacao extends Gasto {
    private static double DEDUCAO_MAX_EDUCA = 2000;
    private final String nomeInstituicao;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public static double getDeducaoMaxEduca() {
        return DEDUCAO_MAX_EDUCA;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

}
