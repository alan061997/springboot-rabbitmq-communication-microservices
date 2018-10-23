package com.example.rabbit.microservicio2.event;

import lombok.*;

import java.io.Serializable;

/**
 * Event received when a multiplication has been solved in the system.
 * Provides some context information about the multiplication.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Data
public class MultiplicationSolvedEvent implements Serializable {

    private String texto;

    public MultiplicationSolvedEvent(String text) {
        this.texto = text;
    }

/*    public MultiplicationSolvedEvent(String texto) {
        this.texto = texto;
    }*/

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}