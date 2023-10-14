package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Boas práticas na criação de uma classe personalizada de exceção:
 *   - Nome da classe deve terminar com a palavra Exception
 *   - Toda classe de exceção é herdeira da classe mãe Exception
 *   - A classe de exceção deve ser herdeira de Exception com o "extends Exception"
 * */
public class LimiteUltrapassadoException extends Exception {
    String dataHora;

    public LimiteUltrapassadoException(String message) {
        super(message);
        this.dataHora = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss SSS ")
        );
    }
}
