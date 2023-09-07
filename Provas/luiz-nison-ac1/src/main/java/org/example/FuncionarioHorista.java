package org.example;

public class FuncionarioHorista extends Funcionario {
    private Double qtdHora;
    private Double valorHora;

    public FuncionarioHorista(String nome, String codigo, Double qtdHora, Double valorHora) {
        super(nome, codigo);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    public Double getQtdHora() {
        return qtdHora;
    }

    public void setQtdHora(Double qtdHora) {
        this.qtdHora = qtdHora;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public Double getGanho() {
        return this.qtdHora * this.valorHora;
    }

    @Override
    public Double getValorBonus() {
        return getGanho() * 0.10;
    }

    public String toString() {
        return String.format("""
                    Funcionario Horista
                        %s
                        Quantidade hora: %.2f
                        Valor hora: %.2f
                        Total ganho: R$%.2f
                        Quantidade de bônus: R$%.2f
                """, super.toString(), this.qtdHora, this.valorHora,
                this.getGanho(), this.getValorBonus());
    }
}
