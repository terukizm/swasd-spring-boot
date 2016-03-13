package local.swasd.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import local.swasd.api.configuration.error.DevelopErrorAttributes;
import local.swasd.api.configuration.error.ProductionErrorAttributes;
import local.swasd.api.intercepter.APIVersionIntercepter;
import local.swasd.api.intercepter.LoggingIntercepter;

@Configuration
public class ApplicationConfig {
	@Value("${spring.profiles}")
	private String profile;

	@Bean
	public ErrorAttributes errorAttributes() {
		// debug mode
		if (profile.equals("develop")) {
			// return new DefaultErrorAttributes();
			return new DevelopErrorAttributes();
		}
		return new ProductionErrorAttributes();
	}

	@Bean
	public HandlerInterceptor loggingIntercepter() {
		return new LoggingIntercepter();
	}

	@Bean
	public HandlerInterceptor apiVersionIntercepter() {
		return new APIVersionIntercepter();
	}
}