package org.example;

public class Hipopotamo extends Animal {

    public Hipopotamo(String nome, Integer idade, String especie, Integer qtdNinhadasPorAno, Integer qtdFilhotesPorNinhada) {
        super(nome, idade, especie, qtdNinhadasPorAno, qtdFilhotesPorNinhada);
    }

    @Override
    public String toString() {
        return String.format("""
                    Hipopotamo:
                        Nome: %s
                        Idade: %d
                        Espécie: %s
                        Filho por ano: %d
                """, super.getNome(), super.getIdade(), super.getEspecie(), this.totalFilhoteAno());
    }
}
