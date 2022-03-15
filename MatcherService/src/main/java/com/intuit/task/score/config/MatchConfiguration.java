package com.intuit.task.score.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class MatchConfiguration {
	
	@Value("${score.url}")
    private String scoreUrl;
	
	@Bean
	public RestTemplate createScoreRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(scoreUrl));
		return restTemplate;
	}

}
