package pl.infoshareacademy.mail;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class TempFilePath {

    String tempFilePath="";
    String checkboxWord ;
    String checkboxWebsite;
    String checkboxPhone ;
    String checkboxEmails;

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

    public String getCheckboxWord() {
        return checkboxWord;
    }

    public void setCheckboxWord(String checkboxWord) {
        this.checkboxWord = checkboxWord;
    }

    public String getCheckboxWebsite() {
        return checkboxWebsite;
    }

    public void setCheckboxWebsite(String checkboxWebsite) {
        this.checkboxWebsite = checkboxWebsite;
    }

    public String getCheckboxPhone() {
        return checkboxPhone;
    }

    public void setCheckboxPhone(String checkboxPhone) {
        this.checkboxPhone = checkboxPhone;
    }

    public String getCheckboxEmails() {
        return checkboxEmails;
    }

    public void setCheckboxEmails(String checkboxEmails) {
        this.checkboxEmails = checkboxEmails;
    }
    public void setNullforCheckbox() {
        checkboxWord="" ;
        checkboxWebsite="";
        checkboxPhone="";
        checkboxEmails="";
    }
}
