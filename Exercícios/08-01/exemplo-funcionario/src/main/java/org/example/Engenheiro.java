package org.example;

public class Engenheiro extends Funcionario {

    private final Double salario;

    // Constructor
    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    // Métodos
    /* Implementação de métodos abstratos */

    @Override
    public Double calcularSalario() {
        return salario;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                "} " + super.toString();
    }
}
