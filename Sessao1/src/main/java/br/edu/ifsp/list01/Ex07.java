package br.edu.ifsp.list01;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

/*
    Um motorista de Uber estipula o preço de uma determinada viagem dada a quantidade de quilômetros percorrida.
    Para viagens de até X km, é cobrado um valor R$ V1 por km. Acima de X km, é cobrado o valor R$ V2.
    Faça um programa que leia X, V1, V2 e a quantidade de quilômetros A da viagem e imprima o valor total
    com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada    	Saída
    100         75.00
    1.50
    1.25
    50
    Entrada    	Saída
    100         187.50
    1.50
    1.25
    150
*/


public class Ex07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        double V1 = scanner.nextDouble();
        double V2 = scanner.nextDouble();
        double A = scanner.nextDouble();

        Ex07 ex07 = new Ex07();
        System.out.println(String.format("%.2f", ex07.compute(X, V1, V2, A)));
    }

    double compute(int X, double V1, double V2, double A) {
        if (A <= X) {
            return A * V1;
        } else {
            return X * V1 + (A - X) * V2;
        }
    }
}

