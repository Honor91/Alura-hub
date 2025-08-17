package com.alura.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String autor,
        LocalDateTime fechaDeCreacion
) {
    public DatosListaTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getAutor(),
                topico.getFechaDeCreacion()
        );
    }
}
