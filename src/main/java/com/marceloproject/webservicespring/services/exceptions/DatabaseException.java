package com.marceloproject.webservicespring.services.exceptions;

import java.sql.SQLException;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message){
        super(message);
    }
}
