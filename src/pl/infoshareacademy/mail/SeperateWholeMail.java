package pl.infoshareacademy.mail;

public class SeperateWholeMail {
    String message;
    String messagecontent;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SeperateWholeMail{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }
}
