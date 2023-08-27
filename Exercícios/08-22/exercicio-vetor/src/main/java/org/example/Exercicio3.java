package org.example;

import java.util.Scanner;

public class Exercicio3 {

    public static String retornarBuscaNome(String[] vetor, String nomeDigitado) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(nomeDigitado)) {
                return "Nome encontrado no índice " + i;
            }
        }
        return "Nome não encontrado.";
    }
    public static void main(String[] args) {
        String[] vetor = new String[10];

        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um nome: ");
            vetor[i] = leitor.next();
        }

        System.out.println("Digite um nome para procurar: ");
        String nomeDigitado = leitor.next();

        System.out.println(retornarBuscaNome(vetor, nomeDigitado));
    }
}
