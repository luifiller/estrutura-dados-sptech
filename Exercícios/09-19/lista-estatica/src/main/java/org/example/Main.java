package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adicionaElemento(10);
        lista.adicionaElemento(20);
        lista.adicionaElemento(30);
        lista.adicionaElemento(50);
        lista.adicionaElemento(80);
        lista.adicionaElemento(130);

        lista.exibeLista();

        System.out.println("Índice do número 50: " + lista.buscaElementoUnico(50));

        System.out.println("Número 50 removido: " + lista.removeElementoUnico(50));

        lista.exibeLista();
    }
}