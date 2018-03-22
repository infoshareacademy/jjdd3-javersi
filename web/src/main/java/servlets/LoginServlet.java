package servlets;


import com.auth0.AuthenticationController;
import commons.AuthenticationControllerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    public static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private AuthenticationController authenticationController;
    private String domain;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        domain = config.getServletContext().getInitParameter("com.auth0.domain");
        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    private String getRedirectUri(HttpServletRequest req) {
        if (req.getServerPort() == 80) {
            return req.getScheme() + "://" + req.getServerName() + "/callback";
        }

        return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        
        String redirectUri = getRedirectUri(req);
        LOG.info("redirectURI: {}", redirectUri);

        String authorizeUrl = authenticationController.buildAuthorizeUrl(req, redirectUri)
                .withAudience(String.format("https://%s/userinfo", domain))
                .withScope("openid profile")
                .build();
        resp.sendRedirect(authorizeUrl);
    }

}
