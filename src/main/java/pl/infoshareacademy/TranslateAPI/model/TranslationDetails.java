package pl.infoshareacademy.TranslateAPI.model;

public class TranslationDetails {

    private String translatedText;
    private String detectedSourceLanguage;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getDetectedSourceLanguage() {
        return detectedSourceLanguage;
    }

    public void setDetectedSourceLanguage(String detectedSourceLanguage) {
        this.detectedSourceLanguage = detectedSourceLanguage;
    }
}
