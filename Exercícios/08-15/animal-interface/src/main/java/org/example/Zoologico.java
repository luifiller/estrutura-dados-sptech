package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    List<INinhada> listaAnimaisNinhada;
    List<Animal> listaAnimaisSemNinhada;

    public Zoologico() {
        this.listaAnimaisNinhada = new ArrayList<>();
        this.listaAnimaisSemNinhada = new ArrayList<>();
    }

    public void adicionarAnimalNinhada(INinhada a) {
        this.listaAnimaisNinhada.add(a);
    }

    public void adicionarAnimalSemNinhada(Animal a) {
        this.listaAnimaisSemNinhada.add(a);
    }

    public void exibirAnimais() {
        listaAnimaisNinhada.forEach(System.out::println);
        listaAnimaisSemNinhada.forEach(System.out::println);
    }

    public Integer calcularTotalFilhotesPorAno() {
        Integer total = 0;

        for (INinhada a : listaAnimaisNinhada) {
            total += a.getNinhadaPorAno();
        }

        for (Animal a : listaAnimaisSemNinhada) {
            total += a.getQtdFilhotesPorNinhada();
        }

        return total;
    }
}
