package local.swasd.api.configuration;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "swasd")
@Data
public class SwasdConfiguration {
	@NotNull
	private String sample = "test";

	@NotNull
	private String apiVersion;

	@NotNull
	private boolean apiNoVersionCheck = true;

}