package org.example;

public class FuncionarioHoraExtra extends Funcionario {
    private Double salario;
    private Double qtdHoraExtra;
    private Double valorHoraExtra;

    public FuncionarioHoraExtra(String nome, String codigo, Double salario, Double qtdHoraExtra, Double valorHoraExtra) {
        super(nome, codigo);
        this.salario = salario;
        this.qtdHoraExtra = qtdHoraExtra;
        this.valorHoraExtra = valorHoraExtra;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getQtdHoraExtra() {
        return qtdHoraExtra;
    }

    public void setQtdHoraExtra(Double qtdHoraExtra) {
        this.qtdHoraExtra = qtdHoraExtra;
    }

    public Double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(Double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    @Override
    public Double getGanho() {
        return this.salario + (this.qtdHoraExtra * this.valorHoraExtra);
    }

    @Override
    public Double getValorBonus() {
        return getGanho() * 0.15;
    }

    @Override
    public String toString() {
        return String.format("""
                    Funcionario Hora Extra
                        %s
                        Salário: R$%.2f
                        Quantidade hora extra: %.2f
                        Valor hora extra: %.2f
                        Total ganho: R$%.2f
                        Quantidade de bônus: R$%.2f
                """, super.toString(), this.salario, this.qtdHoraExtra,
                this.valorHoraExtra, this.getGanho(), this.getValorBonus());
    }
}
