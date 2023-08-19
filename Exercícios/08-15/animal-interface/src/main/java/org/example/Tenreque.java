package org.example;

public class Tenreque extends Animal implements INinhada {
    public Tenreque(String nome, Integer idade, String especie, Integer qtdNinhadasPorAno, Integer qtdFilhotesPorNinhada) {
        super(nome, idade, especie, qtdNinhadasPorAno, qtdFilhotesPorNinhada);
    }

    @Override
    public Integer getNinhadaPorAno() {
        return getQtdNinhadasPorAno() * getQtdFilhotesPorNinhada();
    }

    @Override
    public String toString() {
        return String.format("""
                    Tenreque:
                        %s
                        Total de filhotes por ano: %d
                """, super.toString(), this.getNinhadaPorAno());
    }
}
