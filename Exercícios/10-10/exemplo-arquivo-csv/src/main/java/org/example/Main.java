package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void gravaArquivoCsv(ListaObj<Cachorro> lista, String nomeArquivo) {
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
                Cachorro dog = lista.getElemento(i);
                saida.format("%d;%s;%s;%.2f\n", dog.getId(), dog.getNome(), dog.getPorte(), dog.getPeso());
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
            System.out.printf("%-4s %-15s %-10s %4s\n", "ID", "NOME", "PORTE", "PESO");
            /*
             * hasNext() retorna "true" enquanto tem linha para ler do arquivo
             * quando ele encontra o fim de arquivo (EOF), o hasNext() retorna "false"
             * */

            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();

                System.out.printf("%04d %-15s %-10s %4.1f\n", id, nome, porte, peso);
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
        /*
         * O que é um arquivo CSV?
         * Comma Separated Values
         * CSV é um formato de arquivo que armazena dados tabelados.
         * É organziado usando vírgulas.
         *
         * Algumas vezes, no Brasil, é separado por ponto e vírgula ";",
         * mas o padrão é a vírgula ",".
         * */

        ListaObj<Cachorro> listaDog = new ListaObj<>(7);
        listaDog.adiciona(new Cachorro(1, "Bilu", "Medio", 10.0));
        listaDog.adiciona(new Cachorro(2, "Rex", "Grande", 20.0));
        listaDog.adiciona(new Cachorro(3, "Toto", "Pequeno", 5.0));
        listaDog.adiciona(new Cachorro(4, "Lulu", "Medio", 10.0));
        listaDog.adiciona(new Cachorro(5, "CLaudio Raio", "Grande", 20.0));
        listaDog.adiciona(new Cachorro(6, "Rex", "Pequeno", 5.0));
        listaDog.adiciona(new Cachorro(7, "Vava", "Medio", 10.0));

        // System.out.println("Lista de Cachorros: ");
        // listaDog.exibe();

        // gravaArquivoCsv(listaDog, "dogs");

        System.out.println("\n Dados lidos do arquivo: ");

        leExibeArquivoCsv("dogs");
    }
}