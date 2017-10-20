package pl.infoshareacademy.mail;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class TempFilePath {

    String tempFilePath="";

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    List<String> keywordsFromServletForm;

    public List<String> getKeywordsFromServletForm() {
        return keywordsFromServletForm;
    }

    public void setKeywordsFromServletForm(List<String> keywordsFromServletForm) {
        this.keywordsFromServletForm = keywordsFromServletForm;
    }
}
