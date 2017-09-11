package error;

import java.io.IOException;

public class CannotLoadMailDataException extends RuntimeException {
    public CannotLoadMailDataException(String message, IOException e) {
        super(message, e);
    }
}
