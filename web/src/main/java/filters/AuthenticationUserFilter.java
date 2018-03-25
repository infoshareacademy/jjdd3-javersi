package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "AuthenticationUserFilter",
        urlPatterns = {"/about", "/find-the-closest-by-address", "/find-the-closest-in-radius-by-address", "/find-the-closest-in-radius",
        "/find-the-closest", "/search-by-country", "/search-by-town"},
        initParams = {
                @WebInitParam(name = "isUser", value = "true")
        })
public class AuthenticationUserFilter implements Filter {

    Boolean isUser;
    @Override
    public void init(FilterConfig filterConfig) {
        Boolean isUser = Boolean.valueOf(filterConfig.getInitParameter("isUser"));
    }

    @Override
    public void destroy() {
        isUser = false;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
        }
        HttpServletResponse response = (HttpServletResponse ) servletResponse;
        response.sendError(404);
    }
}