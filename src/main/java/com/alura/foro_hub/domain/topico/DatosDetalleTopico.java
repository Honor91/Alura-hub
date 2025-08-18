package com.alura.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        Status status,
        LocalDateTime fechaDeCreacion,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getStatus(),
                topico.getFechaDeCreacion(),
                topico.getCurso()
        );
    }
}
