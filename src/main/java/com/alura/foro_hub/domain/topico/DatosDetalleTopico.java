package com.alura.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String autor,
        Status status,
        LocalDateTime fechaDeCreacion,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getAutor(),
                topico.getStatus(),
                topico.getFechaDeCreacion(),
                topico.getCurso()
        );
    }
}
