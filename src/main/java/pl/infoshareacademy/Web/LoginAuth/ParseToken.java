package pl.infoshareacademy.Web.LoginAuth;

import org.apache.commons.codec.binary.Base64;

public class ParseToken {

    public static String parseId(String jwtToken) {
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));
        String[] splitBody = body.split(",");
        String[] splitid = splitBody[1].split("\"");
        String returnUserId = splitid[3];
        return returnUserId;
    }
}