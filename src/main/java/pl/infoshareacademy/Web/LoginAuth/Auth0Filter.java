package pl.infoshareacademy.Web.LoginAuth;

import com.auth0.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.service.LogDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class Auth0Filter implements Filter {

    private static final Logger logger = LogManager.getLogger(Auth0Filter.class.getName());

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/", "/login", "/callback", "/logout", "/shared/email-logo.jpg", "/img/bg-img.jpeg", "/css/common.css")));

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        String path = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        boolean IsNotLogged = accessToken == null && idToken == null;
        if (IsNotLogged && !allowedPath) {
            //logDAO.saveLogToDatabase("Info", "Anonymous user. Redirected to login menu.");
            res.sendRedirect(request.getServletContext().getContextPath() + "/login");
            return;
        }
        next.doFilter(request, response);
        //logDAO.saveLogToDatabase("INFO", "User with id token:{} Access granted with {} ! " + idToken + " " + accessToken );
    }

    public void destroy() {
    }
}