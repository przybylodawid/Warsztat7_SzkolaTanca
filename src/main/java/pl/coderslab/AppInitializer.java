package pl.coderslab;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pl.coderslab.filter.AdminFilter;
import pl.coderslab.filter.LoginFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet =
                container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        FilterRegistration.Dynamic loginFilter = container.addFilter("loginFilter", new LoginFilter());
        loginFilter.addMappingForUrlPatterns(null, true, "/user/*");

        FilterRegistration.Dynamic adminFilter = container.addFilter("adminFilter", new AdminFilter());
        adminFilter.addMappingForUrlPatterns(null, true, "/admin/*");
    }
}