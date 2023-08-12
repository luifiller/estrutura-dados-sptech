package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tributo {
    private List<Tributavel> listaTrib;

    public Tributo() {
        this.listaTrib = new ArrayList<>();
    }

    public void adicionarTributavel(Tributavel tributavel) {
        this.listaTrib.add(tributavel);
    }

    public Double calcularTotalTributo() {
        return listaTrib.stream().mapToDouble(Tributavel::getValorTributo).sum();
    }

    public void exibirTodos() {
        for (Tributavel t: this.listaTrib) {
            System.out.println(t);
        }
    }

    @Override
    public String toString() {
        return "Tributo{" +
                "listaTrib=" + listaTrib +
                '}';
    }
}
