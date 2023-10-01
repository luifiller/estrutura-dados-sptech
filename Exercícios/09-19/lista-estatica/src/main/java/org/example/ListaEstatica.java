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

    public boolean substitui(int valorAntigo, int valorNovo) {
        int valorAntigoExiste = this.buscaElementoUnico(valorAntigo);

        if (valorAntigoExiste == -1) {
            System.out.println("Valor não encontrado.");
            return false;
        }

        for (int i = 0; i < this.nroElem; i++) {
            if (this.vetor[i] == valorAntigo) {
                this.vetor[i] = valorNovo;
                System.out.println("Valor substituido!");
            }
        }

        return true;
    }

    public int contaOcorrencias(int valor) {
        int contador = 0;
        int valorAntigoExiste = this.buscaElementoUnico(valor);

        if (valorAntigoExiste == -1) {
            System.out.printf("O valor %d não encontrado. \n", valor);
            return 0;
        }


        for (int i = 0; i < this.nroElem; i++) {
            if (this.vetor[i] == valor) {
                contador++;
            }
        }

        return contador;
    }

    public boolean adicionaNoInicio(int valor) {
        if (this.nroElem == this.vetor.length) {
            System.out.println("Lista cheia");
            return false;
        }

        for (int i = this.nroElem; i > 0; i--) {
            this.vetor[i] = this.vetor[i - 1];
        }

        this.vetor[0] = valor;
        this.nroElem++;
        return true;
    }
}
