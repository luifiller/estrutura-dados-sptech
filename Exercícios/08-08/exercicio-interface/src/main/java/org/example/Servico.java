package org.example;

public class Servico implements Vendavel {
    private String descricao;
    private Integer codigo;
    private Integer quantHoras;
    private Double valorHora;

    public Servico(String descricao, Integer codigo, Integer quantHoras, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantHoras = quantHoras;
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return String.format("""
                        Serviço {
                            Código: %d
                            Descrição: %s
                            Quantidade Horas: %d
                            Valor Hora: R$%.2f
                            Valor venda: R$%.2f
                        }
                        """, codigo, descricao, quantHoras, valorHora, this.getValorVenda());
    }

    @Override
    public Double getValorVenda() {
        return (this.quantHoras * this.valorHora);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(Integer quantHoras) {
        this.quantHoras = quantHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
}
