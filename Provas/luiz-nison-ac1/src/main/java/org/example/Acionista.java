package org.example;

public class Acionista implements IPossuiBonus {
    private String nome;
    private Integer qtdAcoes;
    private Double precoAcao;

    public Acionista(String nome, Integer qtdAcoes, Double precoAcao) {
        this.nome = nome;
        this.qtdAcoes = qtdAcoes;
        this.precoAcao = precoAcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAcoes() {
        return qtdAcoes;
    }

    public void setQtdAcoes(Integer qtdAcoes) {
        this.qtdAcoes = qtdAcoes;
    }

    public Double getPrecoAcao() {
        return precoAcao;
    }

    public void setPrecoAcao(Double precoAcao) {
        this.precoAcao = precoAcao;
    }

    public Double getTotalValorAcoes() {
        return this.qtdAcoes * this.precoAcao;
    }


    @Override
    public Double getValorBonus() {
        return getTotalValorAcoes() * 0.2;
    }

    @Override
    public String toString() {
        return String.format("""
                    Acionista
                        Nome: %s
                        Quantidade de ações: %d
                        Preço da ação: %.2f
                        Total valor das ações: %.2f
                        Quantidade de bônus: %.2f
                """, this.nome, this.qtdAcoes, this.precoAcao, this.getTotalValorAcoes(), this.getValorBonus());
    }
}
