package org.example;

public class Servico implements Tributavel {
    private String descricao;
    private Double preco;

    public Servico(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public Double getValorTributo() {
        return this.getPreco() * 0.12;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Double getPreco() {
        return this.preco;
    }
}
