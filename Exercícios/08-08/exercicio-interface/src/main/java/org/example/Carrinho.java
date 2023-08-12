package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> cart;

    public Carrinho() {
        this.cart = new ArrayList<>();
    }

    public void adicionaVendavel(Vendavel v) {
        this.cart.add(v);
    }

    public Double calculaTotalVenda() {
        return this.cart.stream().mapToDouble(Vendavel::getValorVenda).sum();
    }

    public void exibeItensCarrinho() {
        for (Vendavel v: this.cart) {
            System.out.println(v);
        }
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "cart=" + this.cart +
                '}';
    }
}
