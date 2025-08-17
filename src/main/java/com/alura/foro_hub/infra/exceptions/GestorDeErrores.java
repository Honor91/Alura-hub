package com.alura.foro_hub.infra.exceptions;

import com.alura.foro_hub.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError400(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex){

        var errores = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errores.stream().map(DatosErrorValidacion::new).collect(Collectors.toList()));
    }

    public record DatosErrorValidacion(String campo,String mensaje){
        public DatosErrorValidacion(FieldError error){
            this(
                    error.getField(),
                    error.getDefaultMessage()
            );
        }
    }
    @ExceptionHandler(ValidacionException.class) //Gestiona la clase que queremos capturar
    public ResponseEntity tratarErrorDeValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
