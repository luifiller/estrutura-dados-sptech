package org.example;

import java.util.Scanner;

public class Main {
    public static void exibeVetor(int[] vetor) {
        System.out.println("Valores do vetor");

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Vetor [%d] = %d \n", i, vetor[i]);
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[5];
        int[] vetor2 = { 10, 20, 30, 40, 50 };
        String[] vetorString = new String[5];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor inteiro: ");
            vetor[i] = leitor.nextInt();
        }

        exibeVetor(vetor);

        System.out.println("Vetor 2");
        exibeVetor(vetor2);
    }
}