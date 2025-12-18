package model;

public class IdGenerator {
    private static int contDeclaracao = 1;
    private static int contGasto = 1;

    public static int gerarContDeclaracao() {
        return contDeclaracao++;
    }

    public static int gerarContGasto() {
        return contGasto++;
    }
}
