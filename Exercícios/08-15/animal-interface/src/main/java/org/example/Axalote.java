package org.example;

public class Axalote extends Animal implements INinhada {
    private Integer qtdPerdaFilhotePorNinhada;

    public Axalote(String nome, Integer idade, String especie, Integer qtdNinhadasPorAno, Integer qtdFilhotesPorNinhada, Integer qtdPerdaFilhotePorNinhada) {
        super(nome, idade, especie, qtdNinhadasPorAno, qtdFilhotesPorNinhada);
        this.qtdPerdaFilhotePorNinhada = qtdPerdaFilhotePorNinhada;
    }

    public Integer getQtdPerdaFilhotePorNinhada() {
        return qtdPerdaFilhotePorNinhada;
    }

    public void setQtdPerdaFilhotePorNinhada(Integer qtdPerdaFilhotePorNinhada) {
        this.qtdPerdaFilhotePorNinhada = qtdPerdaFilhotePorNinhada;
    }

    @Override
    public Integer getNinhadaPorAno() {
        return getQtdNinhadasPorAno() * (getQtdFilhotesPorNinhada() - getQtdPerdaFilhotePorNinhada());
    }

    @Override
    public String toString() {
        return String.format("""
                    Axalote:
                        %s
                        Quantidades de perdas por ninhada: %d
                        Total de filhotes por ano: %d
                """, super.toString(), this.qtdPerdaFilhotePorNinhada, this.getNinhadaPorAno());
    }
}
