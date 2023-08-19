package org.example;

public class TesteBonusEscola {
    public static void main(String[] args) {
        ControleBonus cBonus = new ControleBonus();

        Professor professor01 = new Professor("Célia", 45.0, 10);

        Coordenador coordenador01 = new Coordenador("Gerson", 30.0, 15.0);

        cBonus.adicionarFuncionario(professor01);
        cBonus.adicionarFuncionario(coordenador01);

        cBonus.exibirFuncionarios();

        System.out.printf("Total de bônus: R$%.2f%n", cBonus.calcularTotalBonus());
    }
}
