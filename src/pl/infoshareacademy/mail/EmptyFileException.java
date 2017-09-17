package pl.infoshareacademy.mail;

public class EmptyFileException extends Exception {
    public EmptyFileException() {
    }
    public EmptyFileException(String msg) {
        super(msg);
    }
}
