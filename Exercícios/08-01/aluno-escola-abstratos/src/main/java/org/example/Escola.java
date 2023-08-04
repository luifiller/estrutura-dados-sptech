package org.example;

import java.util.ArrayList;
import java.util.List;

public class Escola {

    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno a) {
        this.alunos.add(a);
    }

    public void exibeTodos() {
        System.out.println(String.format("Lista de todos os alunos da escola %s: ", this.nome));

        for (Aluno a: this.alunos) {
            System.out.println(a);
        }
    }

    public void exibeAlunoGraduacao() {
        System.out.println(String.format("Lista de todos os alunos da graduação da escola %s: ", this.nome));

        for (Aluno a: this.alunos) {
            if (a instanceof AlunoGraduacao) {
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados() {
        System.out.println(String.format("Lista de todos os alunos aprovados da escola %s: ", this.nome));

        for (Aluno a: this.alunos) {
            if (a.calculaMedia() >= 6.0) {
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra) {
        Integer alunosEncontrados = 0;

        for (Aluno a: this.alunos) {
            if (a.getRa().equals(ra)) {
                System.out.println("Aluno encontrado: ");
                System.out.println(a);

                alunosEncontrados ++;
            }
        }

        if (alunosEncontrados.equals(0)) {
            System.out.println(String.format("""
                    Não foi encontrado nenhum aluno com o RA %d.
                    """, ra));
        }
    }

    @Override
    public String toString() {
        return String.format("""
                |      ESCOLA      |
                Nome: %s
                Alunos: \n %s
                """, this.nome, this.alunos);
    }
}
