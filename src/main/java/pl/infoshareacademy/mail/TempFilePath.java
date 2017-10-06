package pl.infoshareacademy.mail;


import pl.infoshareacademy.Web.FileUploadServlet;

import javax.ejb.Singleton;

@Singleton
public class TempFilePath {

    String tempFilePath;

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }
}
