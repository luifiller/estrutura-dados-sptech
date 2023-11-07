package org.example;

public class Exercicio {

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
        int[] vet1 = {1, 3, 3, 1};
        int[] vet2 = {10, 20, 30, 40};
        int[] vet3 = {1, 2, 3, 2, 1};

        System.out.println("vet1 eh palindromo? " + ehPalindromo(vet1));
        System.out.println("vet2 eh palindromo? " + ehPalindromo(vet2));
        System.out.println("vet3 eh palindromo? " + ehPalindromo(vet3));
    }

}
