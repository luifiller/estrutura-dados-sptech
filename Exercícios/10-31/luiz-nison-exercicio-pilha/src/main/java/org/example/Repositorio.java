package org.example;


public class Repositorio {
    private ListaObj<Animal> listaAnimals;
    private PilhaObj<Integer> pilha;
    private FilaObj<Animal> fila;

    //- Instancia os atributos lista e pilha. Pode criar a pilha com tamanho 10
    public Repositorio() {
        this.listaAnimals = new ListaObj<>(10);
        this.pilha = new PilhaObj<>(10);
        this.fila = new FilaObj<>(10);
    }

    public void agendarSalvar(Animal animal) {
        this.fila.insert(animal);
    }

    public void executarAgendado(int qtdOperacoes) {
        if (fila.isEmpty()) {
            System.out.println("Não há operações agendadas.");
        } else {
            if (qtdOperacoes > fila.getTamanho() || qtdOperacoes <= 0) {
                System.out.println("Não há operações suficientes agendadas.");
            } else {
                // Retire da fila a quantidade desejada de operações, executando uma a uma
                for (int i = 0; i < qtdOperacoes; i++) {
                    this.salvar(this.fila.poll());
                }
            }
        }

        for (int i = 0; i < qtdOperacoes; i++) {
            this.salvar(this.fila.poll());
        }
    }

    public void salvar(Animal animal) {
        this.listaAnimals.adiciona(animal);
        this.pilha.push(animal.getId());
    }

    public void deletar(Integer id) {
        int indice = this.listaAnimals.busca(new Animal(id, null, null, null, null, null, null));
        if (indice == -1) {
            System.out.println("ID inexistente");
        } else {
            this.listaAnimals.removePeloIndice(indice);
        }
    }

    public void exibir() {
        if (this.listaAnimals == null) {
            System.out.println("Repositório vazio");
        } else {
            System.out.println("LISTA DE ANIMAIS");
            this.listaAnimals.exibe();

            System.out.println("PILHA DE ANIMAIS");
            this.pilha.exibe();

            System.out.println("FILA DE ANIMAIS");
            this.fila.exibe();
        }
    }

    public void desfazer() {
        if (this.pilha.isEmpty()) {
            System.out.println("Não há nada a desfazer");
        } else {
            this.deletar(this.pilha.pop());
        }
    }
}
