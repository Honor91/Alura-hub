package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private ITopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datos);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>>  listar(@PageableDefault(size=10,sort={"fechaDeCreacion"},direction = Sort.Direction.ASC) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion)
                .map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/buscar")
    public ResponseEntity<Page<DatosListaTopico>> buscarPorCourseAndYear(
            @RequestParam String curso,
            @RequestParam(required = false) Integer year,
            @PageableDefault(size=10,sort={"fechaDeCreacion"},direction = Sort.Direction.ASC) Pageable paginacion){

        if (year != null){
            //Definiendo el Rango del Año
            LocalDateTime inicio = LocalDateTime.of(year,1,1,0,0);
            LocalDateTime fin = LocalDateTime.of(year,12,31,23,59,59);

            var page = repository.findByActivoTrueAndCursoIgnoreCaseAndFechaDeCreacionBetween(curso,inicio,fin,paginacion)
                    .map(DatosListaTopico::new);
            return ResponseEntity.ok(page);
        } else{
            var page = repository.findByActivoTrueAndCursoIgnoreCase(curso,paginacion)
                    .map(DatosListaTopico::new);
            return ResponseEntity.ok(page);
        }

    }



}
