package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Não é possível instanciar (fazer "new") de uma classe abstrata
        // Funcionario funcionario = new Funcionario("333.999.777.88", "Luiz Nison");

        Engenheiro engenheiro01 = new Engenheiro("333.555.555-88", "Luiz Nison", 1500.00);
        Vendedor vendedor01 = new Vendedor("111.555.888-99", "Noemia", 30000.00, 0.10);
        Horista horista01 = new Horista("777.888.999-77", "Claudio", 100, 40.0);

        System.out.println(engenheiro01);
        System.out.println(vendedor01);
        System.out.println(horista01);

        Empresa empresa01 = new Empresa();
        empresa01.adicionarFuncionario(engenheiro01);
        empresa01.adicionarFuncionario(vendedor01);
        empresa01.adicionarFuncionario(horista01);

        empresa01.exibirTodosFuncionarios();
        empresa01.exibirTotalSalario();
        empresa01.exibirHoristas();
    }
}