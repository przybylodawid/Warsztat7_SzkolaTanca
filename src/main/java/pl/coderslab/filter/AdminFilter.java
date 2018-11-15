package pl.coderslab.filter;

import pl.coderslab.model.Role;
import pl.coderslab.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession(true).getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");

        } else {
            boolean isAdmin = false;
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                if ("admin".equals(role.getRoleName())) {
                    isAdmin = true;
                }
            }

            if (isAdmin) {

                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect("/user/home");
            }

        }

//        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}