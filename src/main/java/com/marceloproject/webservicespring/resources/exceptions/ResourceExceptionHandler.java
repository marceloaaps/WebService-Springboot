package com.marceloproject.webservicespring.resources.exceptions;


import com.marceloproject.webservicespring.services.exceptions.DatabaseException;
import com.marceloproject.webservicespring.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest httpRequest){
        String error = "Recurso não encontrado.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError serr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), httpRequest.getRequestURI());

        return ResponseEntity.status(status).body(serr);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dbException(DatabaseException e, HttpServletRequest httpRequest){
        String error = "Erro de requisição no banco de dados.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError serr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), httpRequest.getRequestURI());

        return ResponseEntity.status(status).body(serr);
    }
}