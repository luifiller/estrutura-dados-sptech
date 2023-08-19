package org.example;

public class Coordenador extends Funcionario implements IPossuiBonus {

    private Double qtdHorasPorSemana;

    public Coordenador(String nome, Double valorHora, Double qtdHorasPorSemana) {
        super(nome, valorHora);
        this.qtdHorasPorSemana = qtdHorasPorSemana;
    }

    @Override
    public Double getValorBonus() {
        return this.qtdHorasPorSemana * this.getValorHora() * 4.5 * 0.2;
    }

    public Double getQtdHorasPorSemana() {
        return qtdHorasPorSemana;
    }

    public void setQtdHorasPorSemana(Double qtdHorasPorSemana) {
        this.qtdHorasPorSemana = qtdHorasPorSemana;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHorasPorSemana=" + qtdHorasPorSemana +
                "} " + super.toString();
    }
}
