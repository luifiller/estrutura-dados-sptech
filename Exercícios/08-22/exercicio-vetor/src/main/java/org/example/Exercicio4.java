package org.example;

import java.util.Scanner;

public class Exercicio4 {
    public static Integer exibirOcorrenciaNumero(int[] vetor, Integer numeroDigitado) {
        int qtdOcorrencias = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (numeroDigitado.equals(vetor[i])) {
                qtdOcorrencias++;
            }
        }

        return qtdOcorrencias;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor inteiro: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Digite um número para saber quantas vezes ele aparece no vetor: ");
        Integer numeroDigitado = leitor.nextInt();

        System.out.printf("Quantidade de ocorrências do número %d => %d", numeroDigitado, exibirOcorrenciaNumero(vetor, numeroDigitado));
    }
}
