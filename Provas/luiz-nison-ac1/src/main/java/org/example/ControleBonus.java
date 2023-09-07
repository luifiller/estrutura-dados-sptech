package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<Funcionario> funcionarios;
    private List<Acionista> acionistas;

    public ControleBonus() {
        this.funcionarios = new ArrayList<>();
        this.acionistas = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }
    public void adicionarAcionista(Acionista a) {
        this.acionistas.add(a);
    }

    public Double calcularTotalBonus() {
        Double totalBonusFuncionarios = this.funcionarios.stream().mapToDouble(Funcionario::getValorBonus).sum();
        Double totalBonusAcionistas = this.acionistas.stream().mapToDouble(Acionista::getValorBonus).sum();

        return totalBonusFuncionarios + totalBonusAcionistas;
    }

    public void exibirTodosComBonus() {
        System.out.println("Relação de funcionários que recebem bônus");
        for (Funcionario f: this.funcionarios) {
            System.out.println(f);
        }

        System.out.println("Relação de acionistas que recebem bônus");
        for (Acionista a: this.acionistas) {
            System.out.println(a);
        }
    }
}
