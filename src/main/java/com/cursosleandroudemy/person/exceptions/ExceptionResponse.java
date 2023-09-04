package com.cursosleandroudemy.person.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String mensage;
    private String details;

    public ExceptionResponse(Date timestamp, String mensage, String details) {
        this.timestamp = timestamp;
        this.mensage = mensage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensage() {
        return mensage;
    }

    public String getDetails() {
        return details;
    }

}
