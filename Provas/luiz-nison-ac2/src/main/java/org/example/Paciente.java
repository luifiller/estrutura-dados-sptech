package org.example;

public class Paciente {
    private Integer id;
    private String nome;
    private Boolean proprietario;
    private String sintomas;
    private Integer idade;
    private Double peso;

    public Paciente(Integer id, String nome, Boolean proprietario, String sintomas, Integer idade, Double peso) {
        this.id = id;
        this.nome = nome;
        this.proprietario = proprietario;
        this.sintomas = sintomas;
        this.idade = idade;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getProprietario() {
        return proprietario;
    }

    public void setProprietario(Boolean proprietario) {
        this.proprietario = proprietario;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", proprietario=" + proprietario +
                ", sintomas='" + sintomas + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                '}';
    }
}
