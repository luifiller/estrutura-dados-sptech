package org.example;

public class TestaBonus {
    public static void main(String[] args) {
        FuncionarioHorista fHorista01 = new FuncionarioHorista("David Martinez", "0123", 44.0, 55.0);
        FuncionarioHorista fHorista02 = new FuncionarioHorista("Luiz Nison", "0124", 32.5, 40.0);

        FuncionarioHoraExtra fHoraExtra01 = new FuncionarioHoraExtra("Johny", "0221", 1500.0, 10.0, 10.0);

        Acionista acionista01 = new Acionista("João", 2, 10.0);

        ControleBonus controle = new ControleBonus();

        controle.adicionarFuncionario(fHoraExtra01);
        controle.adicionarFuncionario(fHorista01);
        controle.adicionarFuncionario(fHorista02);

        controle.adicionarAcionista(acionista01);

        controle.exibirTodosComBonus();

        System.out.printf("O total de bônus é: R$%.2f \n", controle.calcularTotalBonus());
    }
}