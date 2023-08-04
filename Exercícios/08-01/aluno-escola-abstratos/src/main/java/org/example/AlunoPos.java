package org.example;

public class AlunoPos extends Aluno {
    private Double nota01;
    private Double nota02;
    private Double notaMonografia;

    public AlunoPos(Integer ra, String nome, Double nota01, Double nota02, Double notaMonografia) {
        super(ra, nome);
        this.nota01 = nota01;
        this.nota02 = nota02;
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calculaMedia() {
        return (this.nota01 + this.nota02 + this.notaMonografia) / 3;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                1ª nota: %.2f
                2ª nota: %.2f
                Nota monografia: %.2f
                Média: %.2f
                |----------------|
                """, super.toString(), this.nota01,
                this.nota02, this.notaMonografia, this.calculaMedia());
    }
}
