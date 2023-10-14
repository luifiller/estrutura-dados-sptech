package org.example;

import java.util.Scanner;

public class ExemploThrow {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("Digite a nota 1 (entre 0 e 10): ");
            Double nota01 = leitor.nextDouble();

            if (nota01 < 0 || nota01 > 10) {
                throw new LimiteUltrapassadoException("ERRO - Valor fora do range de 0 a 10");
            }
            System.out.println("Digite a nota 2 (entre 0 e 10): ");
            Double nota02 = leitor.nextDouble();

            if (nota02 < 0 || nota02 > 10) {
                throw new LimiteUltrapassadoException("ERRO - Valor fora do range de 0 a 10");
            }

            System.out.printf("Média = %.2f", (nota01 + nota02) / 2);
        } catch (LimiteUltrapassadoException erro) {
            System.out.println(erro + " - " + erro.dataHora);
            erro.printStackTrace();
        }

    }
}
