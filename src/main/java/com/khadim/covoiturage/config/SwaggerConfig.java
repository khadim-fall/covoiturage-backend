package com.khadim.covoiturage.config;

import com.khadim.covoiturage.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //@Bean
    public Docket apiDoc(){

        return new Docket(DocumentationType.SWAGGER_2).groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.khadim.covoiturage"))
                .paths(PathSelectors.ant(Constants.APP_ROOT + "/**"))
                .build().apiInfo(apiInfo());

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Gestion des services pour Covoiturage REST API")
                .description("Gestion de Covoiturage (Passager, Conducteur, Véhicule, Trajet, Ville, Reservation ...) Documentation des APIs")
                .contact(new Contact("Khadim FALL", "https://sn.linkedin.com/in/khadim-fall-468173202", "fall.khadim2803@gmail.com"))
                .license("Apache 2.0")
                .version("1.0.0")
                .build();
    }
}
