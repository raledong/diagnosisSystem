package cn.nju;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableJpaAuditing
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/photo").setViewName("FurPhotoGallery");
        registry.addViewController("/repliedphoto").setViewName("RepliedPhoto");
        registry.addViewController("/noreplyphoto").setViewName("NoReplyPhoto");
        registry.addViewController("/detailPhoto?pid=").setViewName("Photodetail");
        registry.addViewController("/category").setViewName("CategoryManagement");
        registry.addViewController("/application").setViewName("ApplicationManagement");
        registry.addViewController("/notice").setViewName("ReleaseNotice");
        registry.addViewController("/classified").setViewName("ClassifiedPhoto");
        registry.addViewController("/classManagement").setViewName("ClassManagement");
        registry.addViewController("/logout").setViewName("login");
        super.addViewControllers(registry);
    }

}