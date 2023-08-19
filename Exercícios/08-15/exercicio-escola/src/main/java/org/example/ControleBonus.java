package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    List<IPossuiBonus> listaFuncionarios;

    public ControleBonus() {
        this.listaFuncionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(IPossuiBonus f) {
        this.listaFuncionarios.add(f);
    }

    public void exibirFuncionarios() {
        listaFuncionarios.forEach(System.out::println);
    }

    public Double calcularTotalBonus() {
        return listaFuncionarios.stream()
                .mapToDouble(IPossuiBonus::getValorBonus)
                .sum();
    }

}
