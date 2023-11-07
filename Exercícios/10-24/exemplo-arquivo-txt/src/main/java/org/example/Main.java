package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList();

        lista.add(new Aluno("01222013", "Denilson Reis", "ADS",
                "Estrutura de Dados", 9.9, 2));
        lista.add(new Aluno("01222093", "Estela Polverini", "ADS",
                "Engenharia de Software", 7.0, 15));
        lista.add(new Aluno("01222077", "Murilo Barbosa", "ADS",
                "Programação Web", 10.0, 0));
        lista.add(new Aluno("04222000", "Mario Bros", "REDES",
                "Segurança da Informação", 8.5, 10));
        lista.add(new Aluno("02221025", "Ana Teixeira", "CCO",
                "Análise de Algoritmos", 7.5, 7));

        // Exibe a lista de alunos
        System.out.println("Lista original:");
        for (Aluno a : lista) {
            System.out.println(a);
        }

//        gravaArquivoTxt(lista, "alunos.txt");

        System.out.println();

        leArquivoTxt("alunos.txt");

    }

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Bloco try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
        }

        // Bloco try-catch para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {
        int contaRegDadosGravados = 0;

        // Monta o registro de header
        String header = "00NOTA20232";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        // Grava o header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de dados (registros de corpo)
        for (Aluno a : lista) {
            String corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFaltas());
            // Grava o registro de corpo
            gravaRegistro(corpo, nomeArq);
            // Contabiliza a quantidade de reg de dados gravados
            contaRegDadosGravados++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDadosGravados);

        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, nome, curso, disciplina;
        Double media;
        int qtdFaltas;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        // Cria uma listaLida para receber os objetos Alunos com os dados lidos do arquivo
        List<Aluno> listaLida = new ArrayList<>();

        // Bloco try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
        }

        // Bloco try-catch para ler o arquivo
        try {
            // Le a primeira linha do arquivo
            registro = entrada.readLine();

            while (registro != null) {
                // Obtem o tipo do registro que sao os 2 primeiros caracteres do registro
                // 0123456...
                // 00NOTA20232
                // 1234567...
                // substring considera os indices iniciando de zero
                // substring espera receber como 1o argumento o indice inicial do que se deseja
                // e o 2o argumento eh o indice final do que se deseja MAIS UM
                // O 2o argumento tem o mesmo valor da posicao final do campo no doc layout

                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um registro de trailer");
                    qtdRegDadosGravados = Integer.parseInt(registro.substring(2, 12));
                    if (qtdRegDadosGravados == contaRegDadosLidos) {
                        System.out.println("Quantidade de reg de dados gravados é compatível com a " +
                                "quantidade de reg de dados lidos");
                    }
                    else {
                        System.out.println("Quantidade de reg de dados gravados é incompatível com a " +
                                "quantidade de reg de dados lidos");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7, 15).trim();
                    nome = registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105, 110).replace(',','.'));
                    qtdFaltas = Integer.parseInt(registro.substring(110, 113));

                    // Contabiliza que leu mais um reg de dados
                    contaRegDadosLidos++;

                    // Criar um objeto Aluno com os dados lidos desse registro
                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFaltas);

                    // Para importar esse dado, podemos fazer
                    // repository.save(a);

                    // No nosso caso, como não estamos conectados a banco de dados,
                    // vamos add o objeto a a uma listaLida
                    listaLida.add(a);
                }
                else {
                    System.out.println("Eh um registro inválido");
                }

                // Le o proximo registro do arquivo
                registro = entrada.readLine();
            } // fim do while

            // Fecha o arquivo
            entrada.close();

        } // fim do try
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        // Aqui tb seria possível enviar toda a lista para o BD
        // repository.saveAll(listaLida);

        // Exibe a lista lida
        System.out.println("\nLista lida:");
        for (Aluno a : listaLida) {
            System.out.println(a);
        }

    }


}