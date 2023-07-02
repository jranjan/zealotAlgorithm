package com.backbase.api.config;

import com.backbase.api.common.data.BackbaseGlobalData;
import com.backbase.api.exc.openapi.OpenApiSpecificationErrorMessage;
import com.backbase.api.exc.openapi.OpenApiSpecificationException;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;


/**
 * Bean to manage the Open API specification for the service.
 */
@Configuration
public class BackbaseOpenApiConfig {
    @Value("${api.info.title: api.info.title}")
    private String title;

    @Value("${api.info.description: api.info.description}")
    private String description;

    private static final String version = BackbaseGlobalData.VERSION;

    @Value("${api.info.contact.name: api.info.contact.name}")
    private String contactName;

    @Value("${api.info.contact.email: api.info.contact.email}")
    private String contactEmail;

    @Value("${api.info.license.name: api.info.license.name}")
    private String licenseName;

    @Value("${api.info.license.url: api.info.license.url}")
    private String licenseUrl;
    @Bean
    public OpenAPI api() throws OpenApiSpecificationException {
        try {
            return new OpenAPI().info(info());
        } catch (Exception e) {
            throw new OpenApiSpecificationException(
                    OpenApiSpecificationErrorMessage.FAILED_TO_LOAD)
                    .set("causeDetails", e);
        }
    }

    private Info info() {
        return new Info()
                .title(title)
                .description(description)
                .version(version)
                .contact(new Contact().name(contactName).email(contactEmail))
                .license(new License().name(licenseName).url(licenseUrl));
    }

}