package org.example;

public class Vendedor extends Funcionario {

    private Double qtdVenda;
    private Double taxa;

    public Vendedor(String cpf, String nome, Double qtdVenda, Double taxa) {
        super(cpf, nome);
        this.qtdVenda = qtdVenda;
        this.taxa = taxa;
    }

    @Override
    public Double calcularSalario() {
        return (this.qtdVenda * this.taxa);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + qtdVenda +
                ", taxa=" + taxa +
                "} " + super.toString();
    }
}
