package com.spydrone.sfgdi.config;

import com.spydrone.sfgdi.services.GreetingRepository;
import com.spydrone.sfgdi.services.GreetingService;
import com.spydrone.sfgdi.services.GreetingServiceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

	@Bean
	GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
		return new GreetingServiceFactory(greetingRepository);
	}

	@Bean
	@Profile("en")
	@Qualifier("i18nService")
	GreetingService i18nEnglishGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("en");
	}

	@Bean
	@Profile("es")
	@Qualifier("i18nService")
	GreetingService i18nSpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("es");
	}

	@Bean
	@Primary
	@Profile("default")
	@Qualifier("i18nService")
	GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("");
	}
}
