package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(50);
        lista.adiciona(80);
        lista.adiciona(130);

        lista.exibe();

        System.out.println("Índice do número 50: " + lista.busca(50));

        System.out.println("Número 50 removido: " + lista.removeElemento(50));

        lista.exibe();
    }
}