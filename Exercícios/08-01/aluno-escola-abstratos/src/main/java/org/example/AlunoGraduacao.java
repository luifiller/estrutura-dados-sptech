package org.example;

public class AlunoGraduacao extends Aluno {
    private Double nota01;
    private Double nota02;

    public AlunoGraduacao(Integer ra, String nome, Double nota01, Double nota02) {
        super(ra, nome);
        this.nota01 = nota01;
        this.nota02 = nota02;
    }

    @Override
    public Double calculaMedia() {
        return (this.nota01 * 0.4) + (this.nota02 * 0.6);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                1ª nota: %.2f
                2ª nota: %.2f
                Média: %.2f
                |----------------|
                """, super.toString(), this.nota01,
                this.nota02, this.calculaMedia());
    }
}
