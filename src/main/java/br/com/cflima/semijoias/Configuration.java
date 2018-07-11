package br.com.cflima.semijoias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**	
 * Anotaçãoo com um conjunto de anotaçãoes responsaveis
 *por informar que esta classe é de configuração
 **/
@SpringBootApplication
public class Configuration {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}
	
	/**
	 * configuração CORS
	 * @return
	 */
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedMethods("*");
            }
        };
    }

}
