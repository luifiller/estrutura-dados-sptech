package org.example;

public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }

    public void adicionaElemento(int elemento) {
        if (this.nroElem == this.vetor.length) {
            System.out.println("Lista cheia");
        } else {
            this.vetor[this.nroElem] = elemento;
            this.nroElem++;
        }
    }

    public void exibeLista() {
        for (int i = 0; i < this.nroElem; i++) {
            System.out.println(this.vetor[i]);
        }
    }

    public int buscaElementoUnico(int elemento) {
        for (int i = 0; i < this.nroElem; i++) {
            if (this.vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePorIndice(int indice) {
        if (indice < 0 || indice >= this.nroElem) {
            return false;
        } else {
            for (int i = indice; i < this.nroElem - 1; i++) {
                this.vetor[i] = this.vetor[i + 1];
            }
            this.nroElem--;
            return true;
        }
    }

    public boolean removeElementoUnico(int elemento) {
        int indice = this.buscaElementoUnico(elemento);
        if (indice == -1) {
            return false;
        } else {
            return this.removePorIndice(indice);
        }
    }
}
