package pl.infoshareacademy.mail;


import java.util.Date;

public class Email {

    private String from;
    private String sender;
    private Date date;
    private String message="";
    private String subject;
    private String to;

    public Email(){}

    public Email(String from, String sender, Date date, String message, String subject) {
        this.from = from;
        this.sender = sender;
        this.date = date;
        this.message = message;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        if (from != null ? !from.equals(email.from) : email.from != null) return false;
        return message != null ? message.equals(email.message) : email.message == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from='" + from + '\'' +
                ", sender='" + sender + '\'' +
                ", date=" + date +
                ", splitMessagetoWholeMessage='" + message + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
