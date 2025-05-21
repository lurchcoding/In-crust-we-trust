package at.incrustwetrust.pizzeria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ObjectAlreadyExcistsExeception extends RuntimeException{
    public ObjectAlreadyExcistsExeception() {
    }

    public ObjectAlreadyExcistsExeception(String message) {
        super(message);
    }

    public ObjectAlreadyExcistsExeception(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectAlreadyExcistsExeception(Throwable cause) {
        super(cause);
    }

    public ObjectAlreadyExcistsExeception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
