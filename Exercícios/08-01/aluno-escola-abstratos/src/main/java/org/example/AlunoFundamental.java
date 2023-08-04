package org.example;

public class AlunoFundamental extends Aluno {
    private Double nota01;
    private Double nota02;
    private Double nota03;
    private Double nota04;

    public AlunoFundamental(Integer ra, String nome, Double nota01,
                            Double nota02, Double nota03, Double nota04) {
        super(ra, nome);
        this.nota01 = nota01;
        this.nota02 = nota02;
        this.nota03 = nota03;
        this.nota04 = nota04;
    }

    @Override
    public Double calculaMedia() {
        return (this.nota01 + this.nota02 + this.nota03 + this.nota04) / 4;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                1ª nota: %.2f
                2ª nota: %.2f
                3ª nota: %.2f
                4ª nota: %.2f
                Média: %.2f
                |----------------|
                """, super.toString(), this.nota01,
                this.nota02, this.nota03, this.nota04,
                this.calculaMedia());
    }
}
