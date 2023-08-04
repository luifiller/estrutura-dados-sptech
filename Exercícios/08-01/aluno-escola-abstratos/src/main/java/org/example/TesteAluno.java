package org.example;

public class TesteAluno {
    public static void main(String[] args) {
        AlunoFundamental alunoFund01 = new AlunoFundamental(1234, "Luiz", 9.0,
                8.5, 9.5, 10.0);
        AlunoFundamental alunoFund02 = new AlunoFundamental(1235, "Julio", 5.0,
                6.5, 4.5, 5.0);

        AlunoGraduacao alunoGrad01 = new AlunoGraduacao(1333, "Claudio", 8.0, 9.5);

        AlunoPos alunoPos01 = new AlunoPos(1223, "Pedro", 10.0, 7.5, 8.7);

        System.out.println(alunoFund01);
        System.out.println(alunoFund02);
        System.out.println(alunoGrad01);
        System.out.println(alunoPos01);

        Escola escola01 = new Escola("Montessori");

        escola01.adicionaAluno(alunoFund01);
        escola01.adicionaAluno(alunoFund02);
        escola01.adicionaAluno(alunoGrad01);
        escola01.adicionaAluno(alunoPos01);

        System.out.println(escola01);

        escola01.exibeTodos();

        escola01.buscaAluno(1234);
        escola01.buscaAluno(1236);

        escola01.exibeAlunoGraduacao();

        escola01.exibeAprovados();
    }
}
