package com.sousa.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sousa.batch.model.Codigo;
import com.sousa.batch.steps.TesteTasklet;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	TesteTasklet testeTasklet;
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job(@Qualifier("stepPadronizar") Step step){
		return jobBuilderFactory.get("job")
				.incrementer(new RunIdIncrementer())
				.start(step)
//				.next()
				.build();
	}
	
	@Bean
	public Step step2(){
		return stepBuilderFactory.get("step2")
				.tasklet(testeTasklet)
				.build();
	}
	
	@Qualifier("stepPadronizar")
	@Bean
	public Step step1(ItemReader <List<Codigo>> itemReader, ItemProcessor <List<Codigo>, List<Codigo>> itemProcessor, ItemWriter <List<Codigo>> itemWriter){
		return stepBuilderFactory.get("step1")
				.<List<Codigo>, List<Codigo>>chunk(10)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
	}
	
}
