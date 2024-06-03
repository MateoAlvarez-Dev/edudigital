package com.riwi.edudigital.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Mateo Alvarez Yepes",
                        url = "https://github.com/MateoAlvarez-Dev",
                        email = "matheoz2003@gmail.com"
                ),
                title = "Documentation: EduDigital test Api",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8080/api/v1/edudigital")
        }
)
public class SwaggerConfig {
}