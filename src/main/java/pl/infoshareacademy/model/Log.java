package pl.infoshareacademy.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    LocalTime time;

    @Column
    String level;

    @Column
    String message;

    public Log() {
    }

    public Log(String message, LocalTime date) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}