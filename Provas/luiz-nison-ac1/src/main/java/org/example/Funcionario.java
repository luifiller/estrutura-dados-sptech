package org.example;

public abstract class Funcionario implements IPossuiBonus {
    private String nome;
    private String codigo;

    public Funcionario(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract Double getGanho();

    @Override
    public String toString() {
        return String.format("""
                Nome: %s
                Código: %s
            """, this.nome, this.codigo);
    }
}
