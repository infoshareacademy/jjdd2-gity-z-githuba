package pl.infoshareacademy.TranslateAPI.model;

import java.util.List;

public class GoogleResponse {

    private List<TranslationDetails> translations;

    public List<TranslationDetails> getTranslations() {
        return translations;
    }

    public void setTranslations(
        List<TranslationDetails> translations) {
        this.translations = translations;
    }
}
