package com.backbase.api.config;

import com.backbase.api.common.BackbaseFrozenData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class BackbaseOpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Backbase API Specification")
                        .description("Gateway to connect to Backbase System using RESTful API")
                        .version(BackbaseFrozenData.VERSION));
    }
}