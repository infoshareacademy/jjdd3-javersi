package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "AuthenticationAdminFilter",
        urlPatterns = {"/administration/*"},
        initParams = {
                @WebInitParam(name = "isUserAdmin", value = "true")
        })
public class AuthenticationAdminFilter implements Filter {

    Boolean isUserAdmin;
    @Override
    public void init(FilterConfig filterConfig) {
        Boolean isUserAdmin = Boolean.valueOf(filterConfig.getInitParameter("isUserAdmin"));
    }

    @Override
    public void destroy() {
        isUserAdmin = false;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            if (user.getRoleAdministration()) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        HttpServletResponse response = (HttpServletResponse ) servletResponse;
        response.sendError(404);
    }
}