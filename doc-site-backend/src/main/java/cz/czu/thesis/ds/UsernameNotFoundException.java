package cz.czu.thesis.ds;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(Class<?> resourceClass, Serializable id) {
        super("Resource " + resourceClass.getSimpleName() + " not found with id='" + id + "'. (HTTP 404).");
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
