package com.alura.foro_hub.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter //crea todos los setters
@NoArgsConstructor //Crea un constructor que no tiene argumentos
@AllArgsConstructor // Crea un constructor con todos los atributos
@EqualsAndHashCode(of = "id") //2 objetos son iguales si tienen el mismo id
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String título;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;
    private String curso;

}
