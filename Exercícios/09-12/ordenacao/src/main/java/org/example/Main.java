package org.example;

import java.util.Arrays;

public class Main {
    public static void selectionSort(int[] v) {
        int comparacao = 0;
        int troca = 0;

        System.out.println("SELECTION SORT");
        System.out.println("Vetor inicial: " + Arrays.toString(v));

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                comparacao++;
                if (v[j] < v[i]) {
                    troca++;

                    int aux = v[i];

                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        System.out.printf("Total de comparações: %d \n", comparacao);
        System.out.printf("Total de trocas: %d \n", troca);
        System.out.println("Vetor ordenado: " + Arrays.toString(v));
    }

    public static void selectionSortOtimizado(int[] v) {
        int comparacao = 0;
        int troca = 0;

        System.out.println("SELECTION SORT OTIMIZADO");
        System.out.println("Vetor inicial: " + Arrays.toString(v));

        for (int i = 0; i < v.length - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < v.length; j++) {
                comparacao++;
                if (v[j] < v[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            troca++;

            int aux = v[i];
            v[i] = v[indiceMenor];
            v[indiceMenor] = aux;
        }

        System.out.printf("Total de comparações: %d \n", comparacao);
        System.out.printf("Total de trocas: %d \n", troca);
        System.out.println("Vetor ordenado: " + Arrays.toString(v));
    }

    public static void bubbleSort(int[] v) {
        int comparacao = 0;
        int troca = 0;

        System.out.println("BUBBLE SORT");
        System.out.println("Vetor inicial: " + Arrays.toString(v));

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 1; j < v.length - i; j++) {
                if (v[j - 1] > v[j]) {
                    comparacao++;
                    troca++;

                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }

        System.out.printf("Total de comparações: %d \n", comparacao);
        System.out.printf("Total de trocas: %d \n", troca);
        System.out.println("Vetor ordenado: " + Arrays.toString(v));
    }

    public static int pesquisaBinaria(int[] v, int valor) {
        int indInferior = 0;
        int indSuperior = v.length - 1;
        int indMeio;

        while (indInferior <= indSuperior) {
            indMeio = (indInferior + indSuperior) / 2;

            if (valor == v[indMeio]) {
                return indMeio;
            } else if (valor < v[indMeio]) {
                indSuperior = indMeio - 1;
            } else {
                indInferior = indMeio + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // int[] v1 = { 4, 7, 5, 2, 10, 8, 1, 6, 3 };
        // int[] v2 = { 4, 7, 5, 2, 8, 1, 6, 3 };
        // int[] v3 = { 4, 7, 5, 2, 10, 8, 1, 6, 3 };
        int[] v4 = { 4, 7, 5, 2, 10, 8, 1, 6, 3 };

        // selectionSort(v1);
        // selectionSortOtimizado(v2);
        // bubbleSort(v3);

        selectionSortOtimizado(v4);

        int valorExistente = 5;
        // int valorAusente = 11;
        int indice = pesquisaBinaria(v4, valorExistente);

        if (indice != -1) {
            System.out.printf("O valor %d foi encontrado no índice %d do vetor v4. \n", valorExistente, indice);
        } else {
            System.out.printf("O valor %d não foi encontrado no vetor v4. \n", valorExistente);
        }
    }
}