package org.example;

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] dias = {31,28,31,30,31,30,31,31,30,31,30,31};
        int diaDigitado;
        int mesDigitado;

        System.out.println("Digite o dia: ");
        diaDigitado = leitor.nextInt();

        System.out.println("Digite o mês: ");
        mesDigitado = leitor.nextInt();

        int diasPercorridos = 0;
        for (int i = 0; i < mesDigitado - 1; i++) {
            diasPercorridos += dias[i];
        }
        diasPercorridos += diaDigitado;

        System.out.printf("O dia %d do mês %d corresponde ao dia %d do ano.", diaDigitado, mesDigitado, diasPercorridos);
    }
}
