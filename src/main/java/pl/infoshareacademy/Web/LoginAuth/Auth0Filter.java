package pl.infoshareacademy.Web.LoginAuth;

import com.auth0.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/portal/*")
public class Auth0Filter implements Filter {
    private static final Logger logger = LogManager.getLogger(Auth0Filter.class.getName());

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken == null && idToken == null) {
            logger.info("Anonymous user. Redirected to login menu.");
            res.sendRedirect(request.getServletContext().getContextPath() + "/login");
            return;
        }
        logger.info("Access granted!" );
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}