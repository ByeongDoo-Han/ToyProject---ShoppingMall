package com.example.shoppingmallproject.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GetException extends Throwable {
    private HttpStatus statusCode;
    private String errorMessage;

    public GetException(StatusException statusExceptionCode){
        this.statusCode = statusExceptionCode.getStatusCode();
        this.errorMessage = statusExceptionCode.getErrorMessage();
    }
}