package kr.misoboy.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.misoboy.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .securitySchemes(Collections.singletonList(new BasicAuth("xBasic")))
                .securityContexts(Collections.singletonList(xBasicSecurityContext()))
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Basic Authentication\nid : test\npassword: test123",
                "API v1",
                "Terms of service",
                new Contact("Chiseok Song", "https://dev.misoboy.kr", "misoboy.kor@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    private SecurityContext xBasicSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(
                        new SecurityReference("xBasic", new AuthorizationScope[0])))
                .build();
    }
}
