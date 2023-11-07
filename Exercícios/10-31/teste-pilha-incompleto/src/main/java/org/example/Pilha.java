package org.example;

import java.util.Arrays;

public class Pilha {

    // 01) Atributos
    private int[] pilha;
    private int topo;

    // 02) Construtor
    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    // 03) MÃ©todo isEmpty
    public Boolean isEmpty() {
        return topo == -1;
    }

    // 04) MÃ©todo isFull
    public Boolean isFull() {
        return topo == pilha.length - 1;
    }

    // 05) MÃ©todo push
    public void push(int info) {
        if (!this.isFull()) {
            topo++;
            pilha[topo] = info;
        } else {
            throw new IllegalStateException("Pilha vazia");
        }
    }

    // 06) MÃ©todo pop
    public int pop() {
        if (!this.isEmpty()) {
            return pilha[topo--];
        } else {
            return -1;
        }
    }

    // 07) MÃ©todo peek
    public int peek() {
        if (!this.isEmpty()) {
            return pilha[topo];
        } else {
            return -1;
        }
    }

    // 08) MÃ©todo exibe
    public void exibe() {
        if (!this.isEmpty()) {
            System.out.printf("Exibindo da base ao topo %s", Arrays.toString(pilha));
        } else {
            System.out.println("Pilha vazia");
        }
    }

    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}