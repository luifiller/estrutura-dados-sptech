package org.example;

public class Fila {
    // Atributos
    private int tamanho;
    private String[] fila;

    // Construtor
    public Fila(int capaciade) {
        this.tamanho = 0;
        this.fila = new String[capaciade];
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return this.tamanho == this.fila.length;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia.");
        }

        this.fila[this.tamanho] = info;
        this.tamanho++;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        return this.fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public String poll() {
        String primeiro = this.fila[0];
        if (!this.isEmpty()) {

            for (int i = 0; i < this.tamanho - 1; i++) {
                this.fila[i] = this.fila[i + 1];

                if (i == this.tamanho - 2) {
                    this.fila[i + 1] = null;
                }
            }

            this.tamanho--;
        }
        return primeiro;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.printf("%d - %s \n", i, this.fila[i]);
        }
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho() {
        return this.tamanho;
    }
}

