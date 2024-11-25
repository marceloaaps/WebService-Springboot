package com.marceloproject.webservicespring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado no id de número " + id);
    }
}
