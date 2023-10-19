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


    public static void gravaArquivoCsv(ListaObj<Paciente> lista, String nomeArquivo) {
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
                Paciente paciente = lista.getElemento(i);
                saida.format("%d;%s;%b;%s;%d;%.1f\n",
                        paciente.getId(), paciente.getNome(), paciente.getProprietario(),
                        paciente.getSintomas(), paciente.getIdade(), paciente.getPeso());
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
            System.out.printf("%-4s %-14s %-11s %-15s %6s %5s\n",
                    "ID", "NOME", "PROPRIETARIO", "SINTOMAS", "IDADE", "PESO");

            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Boolean proprietario = entrada.nextBoolean();
                String sintomas = entrada.next();
                Integer idade = entrada.nextInt();
                Double peso = entrada.nextDouble();

                System.out.printf("%04d %-14s %-11b %-15s %6d %5.1f\n",
                        id, nome, proprietario, sintomas, idade, peso);
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
        ListaObj<Paciente> lista = new ListaObj<>(6);

        lista.adiciona(new Paciente(11, "Ana Teixeira", false, "Dor de cabeca", 30, 56.0));
        lista.adiciona(new Paciente(12, "Mario Silva", true, "Febre alta", 63, 70.5));
        lista.adiciona(new Paciente(13, "Catia Miranda", false, "Dor na lombar", 45, 61.4));
        lista.adiciona(new Paciente(14, "Fabio Reis", false, "Dor de garganta", 25, 65.7));
        lista.adiciona(new Paciente(15, "Paula Souza", true, "Gestante", 27, 57.7));
        lista.adiciona(new Paciente(16, "Lauro Macedo", true, "Pedra no rim", 65, 68.3));

        gravaArquivoCsv(lista, "paciente");
        leExibeArquivoCsv("paciente");
    }
}