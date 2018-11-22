package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@SpringBootApplication
@ComponentScan
public class CrudApplication {
    
    @Bean(name ="templateResolver") 
    public SpringResourceTemplateResolver getTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver(); 
    //templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("XHTML");
    return templateResolver;
    }
    @Bean(name ="templateEngine") 
    public SpringTemplateEngine getTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(getTemplateResolver());
    return templateEngine;
    }
    @Bean(name="viewResolver")
    public ThymeleafViewResolver getViewResolver(){
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver(); 
    viewResolver.setTemplateEngine(getTemplateEngine());
    return viewResolver;
    }

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
