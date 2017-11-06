package pl.infoshareacademy.Web.portal;

import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.EmlParser;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;
import pl.infoshareacademy.service.LogDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/checkFiles")
public class FileCheckServlet extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Inject
    MailBox mailBox;

    @Inject
    LogDAO logDAO;

    private static final String UPLOAD_DIR = "/uploads";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<String> uploadStatusOKButWarn = new HashSet<>();
        tryToParse(uploadStatusOKButWarn);
       // filePath.setUploadStatusOKButWarn(uploadStatusOKButWarn);

        req.setAttribute("fileOK", filePath.getUploadStatusOK());
        req.setAttribute("fileNotOK", filePath.getUploadStatusNotOK());
        req.setAttribute("fileWarn", uploadStatusOKButWarn);
        getServletContext().getRequestDispatcher("/shared/check_files.jsp").forward(req, resp);
    }

    private void tryToParse(Set<String> uploadStatusOKButWarn) {
        for (String pathToParse : filePath.getIsParsableCheck()) {
            File f = new File(pathToParse);
            if (pathToParse.endsWith("mbox")) {
                MboxParser mboxParser = new MboxParser(pathToParse);
                try {
                    mboxParser.run(mailBox);
                } catch (Exception ebox) {
                    logDAO.saveLogToDatabase("WARNING", "cant parse mbox " + f.getName());
                    uploadStatusOKButWarn.add(f.getName() + ": contains some lock markers that can cause our program to display messages incorrectly");
                }
            } else if (pathToParse.endsWith("eml")) {
                try {
                    EmlParser.parseEml(pathToParse, mailBox);
                } catch (Exception eeml) {
                    logDAO.saveLogToDatabase("WARNING", "cant parse eml " + f.getName());
                    uploadStatusOKButWarn.add(f.getName() + ": contains some lock markers that can cause our program to display messages incorrectly");
                }
            }
            f.delete();
        }
    }
}
