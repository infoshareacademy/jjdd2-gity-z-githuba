package pl.infoshareacademy.Web;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Constants {
    public static GoogleAuthorizationCodeFlow flow;
    public static HttpTransport httpTransport;
    public static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
}
