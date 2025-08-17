package com.alura.foro_hub.domain.topico;


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
    private String titulo;
    private String mensaje;
    @Column(name ="fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;
    private String curso;

    public Topico( DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.activo = true;
        this.status = Status.ABIERTO;
        this.autor = datos.autor();
        this.curso = datos.curso();

    }
}
