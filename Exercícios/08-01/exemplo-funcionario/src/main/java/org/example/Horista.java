package org.example;

public class Horista extends Funcionario {

    private Integer qtdHora;
    private Double valorHora;

    public Horista(String cpf, String nome, Integer qtdHora, Double valorHora) {
        super(cpf, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    @Override
    public Double calcularSalario() {
        return (this.qtdHora * this.valorHora);
    }

    @Override
    public String toString() {
        return "Horista{" +
                "qtdHora=" + qtdHora +
                ", valorHora=" + valorHora +
                "} " + super.toString();
    }
}
