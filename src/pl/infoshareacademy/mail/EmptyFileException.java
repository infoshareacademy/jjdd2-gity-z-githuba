package pl.infoshareacademy.mail;

public class EmptyFileException extends Throwable {
    public EmptyFileException(String empty_file) {
        System.out.println(empty_file);
    }
}
