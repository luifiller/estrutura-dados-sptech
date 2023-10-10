package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        Integer opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        ListaObj<Animal> animais = new ListaObj(5);

        System.out.println("|                  ZOOLÓGICO                  |");
        do {
            System.out.println("Escolha a opção desejada: (digite 1, 2 ou 3)");
            System.out.println("1 - Adicionar um animal");
            System.out.println("2 - Exibir lista de animais");
            System.out.println("3 - Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do animal:");
                    int id = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nome = leitorNl.nextLine();

                    System.out.println("Digite a idade:");
                    Integer idade = leitor.nextInt();

                    System.out.println("Digite o peso:");
                    Double peso = leitor.nextDouble();

                    System.out.println("Digite o especie:");
                    String especie = leitorNl.nextLine();

                    System.out.println("Digite o altura:");
                    Double altura = leitor.nextDouble();

                    System.out.println("Digite o sexo:");
                    String sexo = leitorNl.nextLine();

                    animais.adiciona(new Animal(id, idade, nome, peso, especie, altura, sexo));

                    System.out.println("Animal cadastrado!");
                    break;
                case 2:
                    System.out.println("");
                    System.out.printf("%-6s %-9s %-5s %-12s %-12s %-6s %-7s\n", "CÓDIGO", "NOME", "IDADE", "SEXO", "ESPECIE", "PESO", "ALTURA");
                    for (int i = 0; i < animais.getTamanho(); i++) {
                        Animal p = animais.getElemento(i);
                        System.out.printf("%06d %-9s %-5d %-12s %-12s %-6.2f %-7.2f\n", p.getId(), p.getNome(), p.getIdade(), p.getSexo(), p.getEspecie(), p.getPeso(), p.getAltura());
                    }
                    System.out.printf("");
                    break;
                case 3:
                    System.out.println("Obrigada por vir ao Zoológico e volte sempre.");
                    break;
                default:
                    System.out.println("Opção digitada inválida");
                    break;
            }
        } while (opcao != 3);

    }
}