package it.project.initializer;
import it.project.provider.ServiceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;

@Configuration
@EnableWebMvc
@ComponentScan({
		"it.project.controller"
})
public class AppConfig
{
	@Bean
	public ServiceProvider getServiceProvider()
	{
		return new ServiceProvider();
	}
}


