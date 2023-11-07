package org.example;

public class Animal {
    private Integer id;
    private Integer idade;
    private String nome;
    private Double peso;
    private String especie;
    private Double altura;
    private String sexo;

    public Animal(Integer id, Integer idade, String nome, Double peso, String especie, Double altura, String sexo) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.especie = especie;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Animal {" +
                "id=" + id +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", especie='" + especie + '\'' +
                ", altura=" + altura +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
