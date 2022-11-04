package com.trendyol.meetup.api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${swagger.host.url}")
    private String host;

    @Value("${swagger.host.path}")
    private String path;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).host(host).pathMapping(path)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.trendyol.meetup.api.infrastructure.web"))
            .paths(PathSelectors.any())
            .build()
            .protocols(new HashSet<>(Arrays.asList("https", "http")));
    }

}
