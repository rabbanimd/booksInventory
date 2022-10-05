package com.cortes.books.resolve.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private String fieldName;
    private String resourceName;
    private String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName+" Not Found with "+fieldName+" : "+fieldValue.toString());
        this.fieldName = fieldName;
        this.fieldValue = fieldValue.toString();
        this.resourceName = resourceName;
    }

}
