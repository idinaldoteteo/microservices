package com.store.notification.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(info=@Info(title="Titulo da minha doc", description="Microsserviço de notificação", version="v1", license=@License(name="MIT", url="http://localhost")))
public class SwaggerConfig {

}
