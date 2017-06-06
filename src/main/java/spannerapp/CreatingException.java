package spannerapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Siekacz on 06.06.2017.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class CreatingException extends Exception {
    public CreatingException(String creatingContentType){super("Could not create new " + creatingContentType);}
}
