package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] vetorT1 = new String[10];
        String[] vetorT2 = new String[10];
        Scanner leitor = new Scanner(System.in);
        Integer totalAlunos = 0;
        Integer qtdAlunosT1 = 0;
        Integer qtdAlunosT2 = 0;

        do {
            System.out.println("Digite o nome do Aluno: ");
            String nome = leitor.next();

            System.out.printf("Digite a turma do Aluno %s: ", nome);
            String turma = leitor.next();

            switch (turma.toLowerCase()) {
                case "t1":
                    vetorT1[qtdAlunosT1] = nome;
                    qtdAlunosT1++;
                    totalAlunos++;

                    break;
                case "t2":
                    vetorT2[qtdAlunosT2] = nome;
                    qtdAlunosT2++;
                    totalAlunos++;

                    break;
                default:
                    System.out.println("Turma inválida!");
            }
        } while (totalAlunos < 10);

        System.out.println("Quantidade de alunos da turma 1: " + qtdAlunosT1);
        for (int i = 0; i < qtdAlunosT1; i++) {
            System.out.println(vetorT1[i]);
        }

        System.out.println("Quantidade de alunos da turma 2: " + qtdAlunosT2);
        for (int i = 0; i < qtdAlunosT1; i++) {
            System.out.println(vetorT2[i]);
        }

    }
}