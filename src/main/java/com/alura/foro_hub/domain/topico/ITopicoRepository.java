package com.alura.foro_hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByActivoTrue(Pageable paginacion);

    Page<Topico> findByActivoTrueAndCursoIgnoreCaseAndFechaDeCreacionBetween(String curso, LocalDateTime inicio, LocalDateTime fin, Pageable paginacion);

    Page<Topico> findByActivoTrueAndCursoIgnoreCase(String curso, Pageable paginacion);
}
