package org.example;

public abstract class Animal {
    private String nome;
    private Integer idade;
    private String especie;
    private Integer qtdNinhadasPorAno;
    private Integer qtdFilhotesPorNinhada;

    public Animal(String nome, Integer idade, String especie, Integer qtdNinhadasPorAno, Integer qtdFilhotesPorNinhada) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.qtdNinhadasPorAno = qtdNinhadasPorAno;
        this.qtdFilhotesPorNinhada = qtdFilhotesPorNinhada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getQtdNinhadasPorAno() {
        return qtdNinhadasPorAno;
    }

    public void setQtdNinhadasPorAno(Integer qtdNinhadasPorAno) {
        this.qtdNinhadasPorAno = qtdNinhadasPorAno;
    }

    public Integer getQtdFilhotesPorNinhada() {
        return qtdFilhotesPorNinhada;
    }

    public void setQtdFilhotesPorNinhada(Integer qtdFilhotesPorNinhada) {
        this.qtdFilhotesPorNinhada = qtdFilhotesPorNinhada;
    }

    @Override
    public String toString() {
        return String.format("""
                Animal
                        Nome: %s
                        Idade: %d
                        Espécie: %s
                        Quantidade de ninhadas por ano: %d
                        Quantidade de filhotes por ninhada: %d""", this.nome, this.idade, this.especie, this.qtdNinhadasPorAno, this.qtdFilhotesPorNinhada);
    }
}
