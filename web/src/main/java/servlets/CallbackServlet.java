package servlets;

import cdi.UserBean;
import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.Request;
import commons.AuthenticationControllerProvider;
import dto.UserDto;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/callback"})
public class CallbackServlet extends HttpServlet {

    @Inject
    private UserBean userBean;

    private String redirectOnSuccess;
    private String redirectOnFail;
    private AuthenticationController authenticationController;

    public static final Logger LOG = LoggerFactory.getLogger(CallbackServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        redirectOnSuccess = "/home";
        redirectOnFail = "/login";

        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Tokens tokens = authenticationController.handle(req);
            SessionUtils.set(req, "accessToken", tokens.getAccessToken());
            SessionUtils.set(req, "idToken", tokens.getIdToken());

            String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            ServletConfig servletConfig = this.getServletConfig();
            AuthAPI auth = new AuthAPI(AuthenticationControllerProvider.getDomain(servletConfig),
                    AuthenticationControllerProvider.getClientId(servletConfig),
                    AuthenticationControllerProvider.getClientSecret(servletConfig));

            Request<UserInfo> request = auth.userInfo(tokens.getAccessToken());
            UserInfo userInfo = request.execute();

            String userName = (String) userInfo.getValues().get("name");

            UserDto userDto = new UserDto();
            userDto.setId((String) userInfo.getValues().get("sub"));
            userDto.setEmail((String) userInfo.getValues().get("email"));
            userDto.setName((String) userInfo.getValues().get("name"));
            userDto.setLocale((String) userInfo.getValues().get("locale"));
            userDto.setNickname((String) userInfo.getValues().get("nickname"));
            User user = userBean.getUser(userDto);

            req.getSession().setAttribute("user_name",userName);
            req.getSession().setAttribute("user",user);

            resp.sendRedirect(redirectOnSuccess);
        } catch (IdentityVerificationException e) {
            LOG.error("Verification failed", e);
            resp.sendRedirect(redirectOnFail);
        }
    }

}
