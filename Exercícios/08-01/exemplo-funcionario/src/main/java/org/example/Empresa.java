package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios;

    // Para o Constructor de List<>, não é passado nenhum argumento na assinatura
    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void exibirTodosFuncionarios() {
        System.out.println("\n Lista dos funcionários");

        for (Funcionario f: this.funcionarios) {
            System.out.println(f);
        }
    }

    public void exibirTotalSalario() {
        Double totalSalario = 0.0;

        for (Funcionario f: this.funcionarios) {
            totalSalario += f.calcularSalario();
        }

        System.out.printf("\n Total de salários: R$ %.2f \n", totalSalario);
    }

    public void exibirHoristas() {
        System.out.println("\n Lista dos horistas");

        for (Funcionario f: this.funcionarios) {
            if (f instanceof Horista) {
                System.out.println(f);
            }
        }

    }
}
