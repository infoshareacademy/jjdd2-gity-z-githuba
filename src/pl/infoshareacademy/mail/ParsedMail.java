package pl.infoshareacademy.mail;

public class ParsedMail {
    private String from;
    private String mimeType;
    private String contentType;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ParsedMail(String from, String mimeType, String contentType) {
        this.from = from;
        this.mimeType = mimeType;
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "ParsedMail{" +
                "from='" + from + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
