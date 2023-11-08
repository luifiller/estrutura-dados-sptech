package org.example;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(3);

        fila.insert("Hello");
        fila.insert("Alt");
        fila.insert("!");

        System.out.printf("Tamanho da fila: %d \n", fila.getTamanho());

        System.out.printf("Primeiro elemento da fila: %s \n", fila.peek());

        System.out.printf("A lista está cheia? %s \n", fila.isFull());
        System.out.printf("A lista está vazia? %s \n", fila.isEmpty());

        fila.exibe();
    }
}