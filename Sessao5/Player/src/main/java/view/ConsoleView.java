package view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner input = new Scanner(System.in);
    int opcao;

    public int menuPrincipal(){
        System.out.println("------------MENU PRINCIPAL-------------");
        System.out.println("(1) - Inserir time");
        System.out.println("(2) - Atualizar time");
        System.out.println("(3) - Remover time");
        System.out.println("(4) - Listar um time");
        System.out.println("(5) - Listar todos os time");
        System.out.println("(6) - Inserir um player");
        System.out.println("(7) - Atualizar player");
        System.out.println("(8) - Remover player");
        System.out.println("(9) - Listar um player");
        System.out.println("(10) - Listar todos os players");
        opcao = input.nextInt();
        return opcao;
    }

}
