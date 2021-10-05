package cl.rymc;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@PropertySource("file:${APP_ENV}")
@SpringBootApplication
public class RickAndMortyChallengeApplication {

	private static final String RESTEMPLATE_TIMEOUT_KEY = "restemplate.timeout";

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(RickAndMortyChallengeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {

		String strTimeout = env.getProperty(RESTEMPLATE_TIMEOUT_KEY);
		Integer timeout = Integer.parseInt(strTimeout);

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(timeout);
		requestFactory.setReadTimeout(timeout);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
