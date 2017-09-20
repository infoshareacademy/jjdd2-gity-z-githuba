package pl.infoshareacademy.mail;


public class Email {

    private String from;
    private String description;
    private String message;

    public Email(){}

    public Email(final String from,final String description) {
        this.from = from;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        if (from != null ? !from.equals(email.from) : email.from != null) return false;
        return description != null ? description.equals(email.description) : email.description == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from='" + from + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
