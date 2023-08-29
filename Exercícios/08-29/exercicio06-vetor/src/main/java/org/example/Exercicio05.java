package org.example;

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        String[] carros = new String[5];
        Scanner leitor = new Scanner(System.in);
        double[] rendimentos = new double[5];

        for (int i = 0; i < carros.length; i++) {
            System.out.println("Digite o nome do carro: ");
            carros[i] = leitor.nextLine();
        }

        for (int i = 0; i < rendimentos.length; i++) {
            System.out.printf("Digite o rendimento do carro nº %d: ", i);
            rendimentos[i] = leitor.nextDouble();
        }

        double melhorRendimento = rendimentos[0];
        int contador = 0;
        for (int i = 0; i < rendimentos.length; i++) {
            if (rendimentos[i] > melhorRendimento) {
                melhorRendimento = rendimentos[i];
                contador = i;
            }
        }
        System.out.printf("O menor rendimento é do carro %s, com rendimento de %.2f",
                carros[contador], rendimentos[contador]);
    }
}