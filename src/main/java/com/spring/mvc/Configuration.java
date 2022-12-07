package com.spring.mvc;

import com.spring.mvc.facade.BookingFacade;
import com.spring.mvc.repository.EventRepository;
import com.spring.mvc.repository.TicketRepository;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.EventService;
import com.spring.mvc.service.TicketService;
import com.spring.mvc.service.UserService;
import com.spring.mvc.storage.Storage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan("com.spring.mvc")
public class Configuration implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Storage storage() {
        return new Storage();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(storage());
    }

    @Bean
    public EventRepository eventRepository() {
        return new EventRepository(storage());
    }

    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepository(storage());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventRepository());
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService(ticketRepository());
    }

    @Bean
    public BookingFacade bookingFacade() {
        return new BookingFacade(eventService(), userService(), ticketService());
    }

    //    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//
//        // set location of views.
//        vr.setPrefix("/WEB-INF/view/");
//
//        // set the extension of views.
//        vr.setSuffix(".jsp");
//
//        return vr;
//    }

    @Bean
    @Description("Thymeleaf Template Resolver")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/view/");
//        templateResolver.setSuffix(".html");
        // HTML is the default value, added here for the sake of clarity.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false if you want
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
        // SpringTemplateEngine automatically applies SpringStandardDialect and
        // enables Spring's own MessageSource message resolution mechanisms.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        // NOTE 'order' and 'viewNames' are optional
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[]{"*.html", "*.xhtml"});
        return viewResolver;
    }
}
