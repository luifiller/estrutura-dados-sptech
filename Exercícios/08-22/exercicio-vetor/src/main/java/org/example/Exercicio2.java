package org.example;

import java.util.Scanner;

public class Exercicio2 {
    public static Double calcularMedia(int[] vetor) {
        double soma = 0.0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }

        return soma / vetor.length;
    }

    public static void exibirVetor(int[] vetor) {
        System.out.println("Valores na ordem do vetor");

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Vetor [%d] = %d \n", i, vetor[i]);
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor inteiro: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.printf("Média dos valores do vetor: %.2f \n", calcularMedia(vetor));

        exibirVetor(vetor);
    }
}
