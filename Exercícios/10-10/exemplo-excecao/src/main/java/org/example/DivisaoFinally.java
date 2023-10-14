package org.example;

import javax.swing.*;

public class DivisaoFinally {
    public static void main(String[] args) {
        String snum1, snum2;
        int num1, num2;


        snum1 = JOptionPane.showInputDialog("Digite um número:");
        snum2 = JOptionPane.showInputDialog("Digite outro número:");

        try {

            num1 = Integer.parseInt(snum1);
            num2 = Integer.parseInt(snum2);

            JOptionPane.showMessageDialog(null, num1 / num2);

        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null,
                    "Divisão por zero!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Digite apenas números!",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, "Fim de execução");
        }

        System.exit(0);
    }
}
