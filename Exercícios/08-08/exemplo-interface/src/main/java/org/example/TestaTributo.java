package org.example;

public class TestaTributo {
    public static void main(String[] args) {
        Alimento alimento01 = new Alimento(1234, "Alimento saudável", 15.00, 18);

        Perfume perfume01 = new Perfume(1222, "Perfume cheiroso", 120.00, "Ivone");

        Servico servico01 = new Servico("Serviço valioso", 500.00);

        Tributo tributo01 = new Tributo();

        tributo01.adicionarTributavel(alimento01);
        tributo01.adicionarTributavel(perfume01);
        tributo01.adicionarTributavel(servico01);

        System.out.println(String.format("""
                Total de impostos: R$%.2f
                """, tributo01.calcularTotalTributo()));
    }


}
