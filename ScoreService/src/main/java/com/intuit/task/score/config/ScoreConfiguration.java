package com.intuit.task.score.config;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intuit.task.score.logic.ParticailMatchGenericService;
import com.intuit.task.score.logic.ParticailMatchGenericServiceDoubleImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceIntegerImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceLocalDateImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceStringImpl;
import com.intuit.task.score.logic.PartitialMatchService;
import com.intuit.task.score.logic.PartitialMatchServiceImpl;
import com.intuit.task.score.logic.ScoreServiceImpl;

@Configuration
public class ScoreConfiguration {
	
	@Bean("ParticailMatchGenericServiceStringImpl")
	public ParticailMatchGenericService createParticailMatchStringService() {
		return new ParticailMatchGenericServiceStringImpl();
	}
	
	@Bean("ParticailMatchGenericServiceLocalDateImpl")
	public ParticailMatchGenericService createParticailMatchLocalDateService() {
		return new ParticailMatchGenericServiceLocalDateImpl();
	}
	
	@Bean("ParticailMatchGenericServiceDoubleImpl")
	public ParticailMatchGenericService createParticailMatchDoubleDateService() {
		return new ParticailMatchGenericServiceDoubleImpl();
	}
	
	@Bean("ParticailMatchGenericServiceIntegerImpl")
	public ParticailMatchGenericService createParticailMatchIntegerService() {
		return new ParticailMatchGenericServiceIntegerImpl();
	}
	
	@Bean
	public ScoreServiceImpl scoreService(@Autowired @Qualifier("ParticailMatchGenericServiceStringImpl") ParticailMatchGenericService stringImpl
			,@Autowired @Qualifier("ParticailMatchGenericServiceLocalDateImpl") ParticailMatchGenericService localDateImpl
			,@Autowired @Qualifier("ParticailMatchGenericServiceDoubleImpl") ParticailMatchGenericService doubleImpl
			,@Autowired @Qualifier("ParticailMatchGenericServiceIntegerImpl") ParticailMatchGenericService integerImpl) {
		
		Map<Class,ParticailMatchGenericService> mapTypeService = new HashMap<>();
		mapTypeService.put(String.class, stringImpl);
		mapTypeService.put(Integer.class, integerImpl);
		mapTypeService.put(LocalDate.class, localDateImpl);
		mapTypeService.put(Double.class, doubleImpl);
		return new ScoreServiceImpl(mapTypeService);
		
	}

}
