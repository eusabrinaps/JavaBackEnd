import exception.ValorInvalidException;
import model.*;
import repository.DeclaracaoDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DeclaracaoDAO repository = new DeclaracaoDAO();

        while (true) {
            System.out.println("\n=== MENU IRPF ===");
            System.out.println("1. Criar declaração simplificada");
            System.out.println("2. Criar declaração completa");
            System.out.println("3. Adicionar gasto à completa");
            System.out.println("4. Simular imposto");
            System.out.println("5. Listar declarações");
            System.out.println("6. Editar declaração");
            System.out.println("7. Remover declaração");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Ganho tributável: ");
                        double ganho = ler.nextDouble();
                        System.out.print("Valor pago: ");
                        double pago = ler.nextDouble();
                        if (ganho < 0 || pago < 0) throw new ValorInvalidException("Valores não podem ser negativos.");
                        Declaracao d = new DeclaracaoSimplificada(ganho, pago);
                        d.setId(IdGenerator.gerarContDeclaracao());
                        repository.create(d);
                        System.out.println("Simplificada criada." + "ID: " + d.getId());
                    }
                    case 2 -> {
                        System.out.print("Ganho tributável: ");
                        double ganho = ler.nextDouble();
                        System.out.print("Valor pago: ");
                        double pago = ler.nextDouble();
                        if (ganho < 0 || pago < 0) throw new ValorInvalidException("Valores não podem ser negativos.");
                        DeclaracaoCompleta d = new DeclaracaoCompleta(ganho, pago);
                        d.setId(IdGenerator.gerarContDeclaracao());
                        repository.create(d);
                        System.out.println("Completa criada.");
                    }
                    case 3 -> {
                        System.out.print("ID da declaração completa: ");
                        int id = ler.nextInt();
                        ler.nextLine();
                        Declaracao d = repository.getById(id).orElse(null);
                        if (d instanceof DeclaracaoCompleta completa) {
                            System.out.print("Tipo (1=Saúde, 2=Educação): ");
                            int tipo = ler.nextInt();
                            ler.nextLine();
                            System.out.print("Descrição: ");
                            String desc = ler.nextLine();
                            System.out.print("Valor: ");
                            double valor = ler.nextDouble();
                            ler.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = ler.nextLine();

                            Gasto gasto = (tipo == 1)
                                    ? new GastoSaude(IdGenerator.gerarContGasto(), desc, valor, cnpj, "CRM123")
                                    : new GastoEducacao(IdGenerator.gerarContGasto(), desc, valor, cnpj, "IFSP");
                            completa.addGasto(gasto);
                            System.out.println("Gasto adicionado.");
                        } else {
                            System.out.println("Declaração não encontrada ou não é completa.");
                        }
                    }
                    case 4 -> {
                        System.out.print("ID da declaração: ");
                        int id = ler.nextInt();
                        Declaracao d = repository.getById(id).orElse(null);
                        if (d != null) {
                            System.out.println("Valor a pagar: R$" + d.getValorAPagar());
                        } else {
                            System.out.println("Declaração não encontrada.");
                        }
                    }
                    case 5 -> {
                        repository.getAll().forEach(d -> {
                            System.out.println(d.toString());
                        });
                    }
                    case 6 -> {}
                    case 7 -> {
                        System.out.print("ID da declaração: ");
                        int id = ler.nextInt();
                        repository.deleteById(id);
                        System.out.println("Removida.");
                    }
                }
            } catch (ValorInvalidException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
