/* Class for string operations on email header */

import java.util.HashMap;
import java.util.Map;

public class MailProcessor {
    private static final String LINE_DELIMITER = ":";
    private static final String NEWLINE_TAG = "\\r?\\n";
    private static final String FROM_TAG = "Content-Type";
    private static final String MIMEVERSION_TAG = "Mime-Version";
    ;


    private String mailHeadersUnparsed;
    private Map<String, String> result = new HashMap<>();

    public MailProcessor(String mailHeadersUnparsed) {
        this.mailHeadersUnparsed = mailHeadersUnparsed;
    }

    public ParsedMail process() throws Exception {
        if (mailHeadersUnparsed.isEmpty()) {
            throw new UnsupportedOperationException("give some data1!!");
        }

        String[] splittedHeaders = mailHeadersUnparsed.split(NEWLINE_TAG);
        for (String line : splittedHeaders) {
            parseLine(line);
        }

        ParsedMail pm = new ParsedMail(result.get(FROM_TAG), result.get(MIMEVERSION_TAG), null);
        return pm;
    }

    private void parseLine(String line) throws Exception {
        String pre;
        String post;

        String[] splitedLine = line.split(LINE_DELIMITER);

        //if (splitedLine.length != 2) {
        //    throw new Exception("bad line: " + line);
      //  }

        result.put(splitedLine[0], splitedLine[1]);
    }

    public Map<String, String> getResult() {
        return result;
    }
}
