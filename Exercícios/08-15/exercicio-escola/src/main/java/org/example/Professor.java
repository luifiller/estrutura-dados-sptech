package org.example;

public class Professor extends  Funcionario implements IPossuiBonus {
    private Integer qtdAulasPorSemana;

    public Professor(String nome, Double valorHora, Integer qtdAulasPorSemana) {
        super(nome, valorHora);
        this.qtdAulasPorSemana = qtdAulasPorSemana;
    }

    @Override
    public Double getValorBonus() {
        return this.qtdAulasPorSemana * this.getValorHora() * 4.5 * 0.15;
    }

    public Integer getQtdAulasPorSemana() {
        return qtdAulasPorSemana;
    }

    public void setQtdAulasPorSemana(Integer qtdAulasPorSemana) {
        this.qtdAulasPorSemana = qtdAulasPorSemana;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulasPorSemana=" + qtdAulasPorSemana +
                "} " + super.toString();
    }
}
