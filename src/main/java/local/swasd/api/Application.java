package local.swasd.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;

import local.swasd.api.configuration.error.DevelopErrorAttributes;
import local.swasd.api.configuration.error.ProductionErrorAttributes;

@SpringBootApplication
public class Application {

	@Value("${spring.profiles}")
	private String profile;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		// debug mode
		if (profile.equals("develop")) {
			// return new DefaultErrorAttributes();
			return new DevelopErrorAttributes();
		}

		return new ProductionErrorAttributes();
	}
}