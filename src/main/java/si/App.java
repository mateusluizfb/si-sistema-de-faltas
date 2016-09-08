package si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

/**
 * Created by mateus on 06/09/16.
 */

@SpringBootApplication
@EnableJpaRepositories
public class App implements ServletContextAware {

    @Bean
    public ServletRegistrationBean getFacesServlet() {
        return new ServletRegistrationBean(new FacesServlet(), "*.jsf");
    }

    @Override
    public void setServletContext(ServletContext context) {
        context.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
    }
}
