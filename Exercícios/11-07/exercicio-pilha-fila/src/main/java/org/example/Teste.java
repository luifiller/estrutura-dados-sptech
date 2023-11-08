package org.example;

import java.util.ArrayList;

public class Teste {
    // recebe um vetor de Integer
    public static void separaPositivoNegativoEmOrdem(Integer[] vetor) {
        FilaObj<Integer> positivo = new FilaObj<>(vetor.length);
        FilaObj<Integer> negativo = new FilaObj<>(vetor.length);

        for (Integer i : vetor) {
            if (i >= 0) {
                positivo.insert(i);
            } else {
                negativo.insert(i);
            }
        }

        while (!positivo.isEmpty()) {
            System.out.println(positivo.poll());
        }

        while (!negativo.isEmpty()) {
            System.out.println(negativo.poll());
        }
    }

    public static void separaPositivoNegativoOrdemDiferente(Integer[] vetor) {
        FilaObj<Integer> positivo = new FilaObj<>(vetor.length);
        PilhaObj<Integer> negativo = new PilhaObj<>(vetor.length);

        for (Integer i : vetor) {
            if (i >= 0) {
                positivo.insert(i);
            } else {
                negativo.push(i);
            }
        }

        while (!positivo.isEmpty()) {
            System.out.println(positivo.poll());
        }

        while (!negativo.isEmpty()) {
            System.out.println(negativo.pop());
        }
    }

    public static void main(String[] args) {
        Integer[] vFila = {2, 7, -3, -50, 45, -4, 30, -21, 38};
        Integer[] vPilha = {2, 7, -3, -50, 45, -4, 30, -21, 38};

        System.out.println("FILA");
        separaPositivoNegativoEmOrdem(vFila);

        System.out.println("PILHA");
        separaPositivoNegativoOrdemDiferente(vPilha);
    }
}
