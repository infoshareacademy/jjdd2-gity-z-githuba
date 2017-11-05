package pl.infoshareacademy.TranslateAPI;

import pl.infoshareacademy.TranslateAPI.model.ResponseContainer;
import pl.infoshareacademy.TranslateAPI.model.error.ErrorResponseContainer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class GoogleTranslate {

    private final String API_KEY;

    public GoogleTranslate(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String translate(String input, String source, String target) {
        String url = "https://translation.googleapis.com/language/translate/v2";
        Form form = new Form();
        form.param("key", API_KEY);
        form.param("q", input);
        form.param("target", target);
        form.param("source", source);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Response response = webTarget.request().post(Entity.form(form));

        if (response.getStatus() >= 400) {
            ErrorResponseContainer errorResponseContainer = response
                    .readEntity(ErrorResponseContainer.class);
            response.close();
            return errorResponseContainer.getError().getErrors().get(0).getMessage();
        } else {
            ResponseContainer responseContainer = response.readEntity(ResponseContainer.class);
            response.close();
            return responseContainer.getData().getTranslations().get(0).getTranslatedText();
        }
    }
}