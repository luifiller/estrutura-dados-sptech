package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void gravaArquivoCsv(ListaObj<Animal> lista, String nomeArquivo) {
        FileWriter arq = null; // representa o arquivo que será gravado
        Formatter saida = null; // objeto de saída será usado para escrever no arquivo
        Boolean deuRuim = false;

        try {
            arq = new FileWriter(nomeArquivo + ".csv");
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo!");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Animal animal = lista.getElemento(i);
                saida.format("%d;%s;%d;%s;%s;%.2f;%.2f\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getEspecie(),
                        animal.getSexo(), animal.getPeso(), animal.getAltura());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar arquivo!");
            deuRuim = true;

        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArquivo) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArquivo += ".csv";

        try {
            arq = new FileReader(nomeArquivo);
            entrada = new Scanner(arq).useDelimiter(";|\\n");

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo inexistente!");
            System.exit(1);
        }

        try {
            System.out.printf("%-6s %-9s %-5s %-12s %-12s %-8s %-6s\n",
                    "CÓDIGO", "NOME", "IDADE", "ESPECIE", "SEXO", "PESO", "ALTURA");
            /*
             * hasNext() retorna "true" enquanto tem linha para ler do arquivo
             * quando ele encontra o fim de arquivo (EOF), o hasNext() retorna "false"
             * */

            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                String especie = entrada.next();
                String sexo = entrada.next();
                Double peso = entrada.nextDouble();
                Double altura = entrada.nextDouble();

                System.out.printf("%06d %-9s %-5d %-12s %-12s %-8.2f %-6.2f\n",
                        id, nome, idade, especie, sexo, peso, altura);
            }
        } catch (NoSuchElementException erro) {
            System.out.printf("Arquivo com problemas!\n");
            erro.printStackTrace();
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.printf("Erro na leitura do arquivo!\n");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

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
            System.out.println("3 - Gravar arquivo CSV");
            System.out.println("4 - Ler arquivo CSV");
            System.out.println("5 - Sair");
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
                    System.out.printf("%-6s %-9s %-5s %-12s %-12s %-8s %-7s\n",
                            "CÓDIGO", "NOME", "IDADE", "SEXO", "ESPECIE", "PESO", "ALTURA");
                    for (int i = 0; i < animais.getTamanho(); i++) {
                        Animal p = animais.getElemento(i);
                        System.out.printf("%06d %-9s %-5d %-12s %-12s %-8.2f %-7.2f\n",
                                p.getId(), p.getNome(), p.getIdade(), p.getSexo(),
                                p.getEspecie(), p.getPeso(), p.getAltura());
                    }
                    System.out.printf("");
                    break;

                case 3:
                    if (animais.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há nada a gravar.");
                        break;
                    } else {
                        gravaArquivoCsv(animais, "zoologico");
                        break;
                    }
                case 4:
                    leExibeArquivoCsv("zoologico");
                    break;

                case 5:
                    System.out.println("Obrigada por vir ao Zoológico e volte sempre.");
                    break;

                default:
                    System.out.println("Opção digitada inválida");
                    break;
            }
        } while (opcao != 5);

    }
}