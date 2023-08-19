package org.example;

public class TesteNinhada {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();

        Axalote axalote01 = new Axalote("Xole", 2, "Axalote", 2, 10, 2);

        Tenreque tenreque01 = new Tenreque("Jorge", 1, "Tenreque", 2, 20);

        Hipopotamo hipopotamo01 = new Hipopotamo("Hipo", 5, "Hipopótamo", 1, 1);

        zoo.adicionarAnimalNinhada(axalote01);
        zoo.adicionarAnimalNinhada(tenreque01);
        zoo.adicionarAnimalSemNinhada(hipopotamo01);

        zoo.exibirAnimais();

        System.out.printf("Total de filhotes por ano: %d", zoo.calcularTotalFilhotesPorAno());
    }
}
