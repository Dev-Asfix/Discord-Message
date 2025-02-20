package com.dev.discord.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje no puede estar vacio")
    private String text;

    @Future(message = "La fecha debe ser en el futuro")
    private LocalDateTime scheduledDate;

    public Message(DatosRegistroMensaje datosRegistroMensaje) {
        this.text = datosRegistroMensaje.text();
        this.scheduledDate = datosRegistroMensaje.scheduledDate();
    }
}
