package org.example;

import java.util.Scanner;

public class Main {
    public static void exibeVetor(int[] vetor) {
        System.out.println("Valores do vetor");

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Vetor [%d] = %d \n", i, vetor[i]);
        }
    }

    // Criar um vetor de Strings inicializado com os nomes dos dias da semana
    // Solicitar que o usuário digite um número de 1 a 7
    // Enquanto o usuário não digitar um valoor válido, ficar em loop solicitando novamente
    // Exibir o dia da semana correspondente ao número digitado
   public static void exibirDiaSemana() {
       String[] diasSemana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };
       int dia = 0;
       Scanner leitor = new Scanner(System.in);

       while (dia < 1 || dia > 7) {
           System.out.println("Digite um número de 1 a 7: ");
           dia = leitor.nextInt();
       }
       System.out.printf("Dia da semana: %s", diasSemana[dia - 1]);
   }

    // Exibir as somas dos valores de cada vetor
   public static void exibirSomaVetor(int[] vetor) {
       int soma = 0;
       for (int v : vetor) {
           soma += v;
       }
       System.out.printf("Soma do vetor: %d \n", soma);
   }

   // Exibir a quantidade de valores pares do vetor
   public static void exibirQtdPares(int[] vetor) {
       int qtdPares = 0;
       for (int v : vetor) {
           qtdPares = v % 2 == 0 ? qtdPares + 1 : qtdPares;
       }
       System.out.printf("Quantidade de pares: %d \n", qtdPares);
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

        System.out.println("Soma vetor 1");
        exibirSomaVetor(vetor);

        System.out.println("Soma vetor 2");
        exibirSomaVetor(vetor2);

        System.out.println("Quantidade de números pares do vetor 1");
        exibirQtdPares(vetor);

        System.out.println("Quantidade de números pares do vetor 2");
        exibirQtdPares(vetor2);

        exibirDiaSemana();
    }
}