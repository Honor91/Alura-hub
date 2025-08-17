package com.alura.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String autor,
        LocalDateTime fechaDeCreacion
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getAutor(),
                topico.getFechaDeCreacion()
        );
    }
}
