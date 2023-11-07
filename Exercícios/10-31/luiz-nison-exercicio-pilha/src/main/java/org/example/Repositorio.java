package org.example;


public class Repositorio {
    private ListaObj<Animal> listaAnimals;
    private Pilha<Integer> pilha;

    //- Instancia os atributos lista e pilha. Pode criar a pilha com tamanho 10
    public Repositorio() {
        this.listaAnimals = new ListaObj<Animal>(10);
        this.pilha = new Pilha<>(10);
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
            this.listaAnimals.exibe();
        }
        this.pilha.exibe();
    }

    public void desfazer() {
        if (this.pilha.isEmpty()) {
            System.out.println("Não há nada a desfazer");
        } else {
            this.deletar(this.pilha.pop());
        }
    }
}
