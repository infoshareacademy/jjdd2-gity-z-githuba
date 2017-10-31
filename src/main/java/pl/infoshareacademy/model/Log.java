package pl.infoshareacademy.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String message;

    @Column
    LocalDate time;

    public Log() {
    }

    public Log(String message, LocalDate date) {
        this.message = message;
        this.time = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
