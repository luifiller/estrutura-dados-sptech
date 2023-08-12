package org.example;

import java.util.Scanner;

public class TesteCarrinho {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Scanner leitorNumero = new Scanner(System.in);
        Scanner leitor = new Scanner(System.in);

        Integer opcaoDigitada;
        Boolean isFinished;

        do {
            System.out.println("""
                        |------------------------------|
                        |       Lojinha do Lui         |
                        |------------------------------|
                        | 1. Adicionar livro           |
                        | 2. Adicionar DVD             |
                        | 3. Adicionar Serviço         |
                        | 4. Exibir itens do carrinho  |
                        | 5. Exibir total de venda     |
                        | 6. Fim                       |
                        |------------------------------|
                    """);
            opcaoDigitada = leitorNumero.nextInt();

            switch (opcaoDigitada) {
                case 1 -> {
                    do {
                        System.out.println("Digite o código do livro: ");
                        Integer codigo = leitorNumero.nextInt();

                        System.out.println("Digite o preço do livro: ");
                        Double precoCusto = leitorNumero.nextDouble();

                        System.out.println("Digite o nome do livro: ");
                        String nome = leitor.next();

                        System.out.println("Digite o nome do autor do livro: ");
                        String autor = leitor.next();

                        System.out.println("Digite o ISBN do livro: ");
                        String isbn = leitor.next();

                        Livro livro = new Livro(codigo, precoCusto, nome, autor, isbn);
                        carrinho.adicionaVendavel(livro);

                        System.out.println("Deseja adicionar outro livro ao seu carrinho? (S/N)");
                        String resposta = leitor.next();

                        isFinished = !resposta.equalsIgnoreCase("S");

                    } while (isFinished.equals(false));
                }
                case 2 -> {
                    do {
                        System.out.println("Digite o código do DVD: ");
                        Integer codigo = leitorNumero.nextInt();

                        System.out.println("Digite o preço do DVD: ");
                        Double precoCusto = leitorNumero.nextDouble();

                        System.out.println("Digite o nome do DVD: ");
                        String nome = leitor.next();

                        System.out.println("Digite o nome da gravadora do DVD: ");
                        String gravadora = leitor.next();

                        DVD dvd = new DVD(codigo, precoCusto, nome, gravadora);
                        carrinho.adicionaVendavel(dvd);

                        System.out.println("Deseja adicionar outro DVD ao seu carrinho? (S/N)");
                        String resposta = leitor.next();

                        isFinished = !resposta.equalsIgnoreCase("S");

                    } while (!isFinished);
                }
                case 3 -> {
                    do {
                        System.out.println("Digite o código do serviço: ");
                        Integer codigo = leitorNumero.nextInt();

                        System.out.println("Digite a descrição do serviço: ");
                        String descricao = leitor.next();

                        System.out.println("Digite a quantidade de horas de serviço: ");
                        Integer quantHoras = leitorNumero.nextInt();

                        System.out.println("Digite o valor da hora do serviço: ");
                        Double valorHora = leitorNumero.nextDouble();

                        Servico servico = new Servico(descricao, codigo, quantHoras, valorHora);
                        carrinho.adicionaVendavel(servico);

                        System.out.println("Deseja adicionar outro serviço ao seu carrinho? (S/N)");
                        String resposta = leitor.next();

                        isFinished = !resposta.equalsIgnoreCase("S");

                    } while (isFinished.equals(false));
                }
                case 4 -> {
                    do {
                        carrinho.exibeItensCarrinho();

                        System.out.println("Deseja exibir novamente os itens do seu carrinho? (S/N)");
                        String resposta = leitor.next();

                        isFinished = !resposta.equalsIgnoreCase("S");
                    } while (isFinished.equals(false));
                }
                case 5 -> {
                    do {
                        System.out.printf("""
                                Total de vendas no carrinho: R$%.2f
                                %n""", carrinho.calculaTotalVenda());

                        System.out.println("Deseja exibir novamente o total de vendas do seu carrinho? (S/N)");
                        String resposta = leitor.next();

                        isFinished = !resposta.equalsIgnoreCase("S");
                    } while (isFinished.equals(false));
                }
                case 6 -> {
                    System.out.println("Muito obrigado por comprar em nossa loja!");
                    opcaoDigitada = 6;
                }
            }
        } while (!opcaoDigitada.equals(6));
    }
}
