package com.alamesa.proyecto.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${swaggerurl-dev}")
	private String urldev;

    @Bean
    OpenAPI config() {
		Contact contact = new Contact();
		contact.setEmail("ejemplo@mail.com");
		contact.setName("Jandro");
		contact.setUrl("https://www.facebook.com/p/IES-Doctor-Fleming-100069216249815/?locale=es_ES");

		License mitLicense = new License().name("MIT License").url("licencia");

		Info info = new Info().title("Documentacion api rest").version("1.0").contact(contact)
				.description("Apis descripcion").license(mitLicense);

		Server devServer = new Server();
		devServer.setUrl(urldev);
		devServer.setDescription("Server URL in Development environment");

		Server prodServer = new Server();
		prodServer.setUrl("prodUrl");
		prodServer.setDescription("Server URL in Production environment");

		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

	}


}
