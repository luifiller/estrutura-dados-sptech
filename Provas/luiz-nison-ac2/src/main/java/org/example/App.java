package org.example;

public class App {
    public static void main(String[] args) {
        ListaEstatica lista1 = new ListaEstatica(7);

        lista1.adicionaElemento(10);
        lista1.adicionaElemento(20);
        lista1.adicionaElemento(30);
         /*Caso para teste de lista cheia
            lista1.adicionaElemento(60);
            lista1.adicionaElemento(50);
            lista1.adicionaElemento(80);
            lista1.adicionaElemento(70);*/

        lista1.adicionaNoIndice(1, 40);
        lista1.exibeLista();
        /* Testes para outros cenários
            lista1.adicionaNoIndice(-1, 111);
            lista1.adicionaNoIndice(4, 111);
            lista1.adicionaNoIndice(0, 5);
            lista1.adicionaNoIndice(2, 111);
        */

        lista1.ordena();
        lista1.exibeLista();

        ListaEstatica lista2 = new ListaEstatica(10);

        lista2.adicionaElemento(8);
        lista2.adicionaElemento(5);
        lista2.adicionaElemento(4);
        lista2.adicionaElemento(7);
        lista2.adicionaElemento(10);
        lista2.adicionaElemento(2);

        lista2.exibeLista();

        lista2.ordena();

        System.out.println("---------------------------------");
        System.out.println("|         LISTA ORDENADA        |");

        lista2.exibeLista();

        int indicePesquisaBinaria = lista2.pesquisaBinaria(5);
        /* Utilizar para testes de outros cenários
            System.out.println(lista2.pesquisaBinaria(2));
            System.out.println(lista2.pesquisaBinaria(10));
            System.out.println(lista2.pesquisaBinaria(9));
        */

        /*
            Alterar o 1º valor do printf, usando aquele indicado no indicePesquisaBinaria
        */
        System.out.printf(
                indicePesquisaBinaria != -1
                        ? "O número %d está na posição %d"
                        : "O número não existe.", 5, indicePesquisaBinaria);
    }
}
