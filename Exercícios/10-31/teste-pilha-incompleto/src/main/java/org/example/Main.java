package org.example;

public class Main {
    public static Boolean ehPalindromo(int[] vetor) {
        Pilha pilha = new Pilha(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            pilha.push(vetor[i]);
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(3);
        pilha.push(0);
        pilha.push(8);

        pilha.pop();
        pilha.push(5);
        pilha.pop();
        /*pilha.pop();*/

        /*pilha.exibe();*/

        int[] vetor = new int[]{1, 2, 3, 2, 1};

        System.out.println(ehPalindromo(vetor));
    }
}