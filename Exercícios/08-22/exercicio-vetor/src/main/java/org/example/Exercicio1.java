package org.example;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[7];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor inteiro: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Valores na ordem do vetor");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Vetor [%d] = %d \n", i, vetor[i]);
        }

        System.out.println("Valores na ordem inversa do vetor");
        for (int i = vetor.length - 1; i > 0; i--) {
            System.out.printf("Vetor [%d] = %d \n", i, vetor[i]);
        }
    }
}
