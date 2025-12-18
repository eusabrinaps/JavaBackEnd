package model;

public final class GastoSaude extends Gasto {
    private static double DEDUCAO_MAX_SAUDE = 15000;
    private final String registroConselho;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public static double getDeducaoMaxSaude() {
        return DEDUCAO_MAX_SAUDE;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }
}
