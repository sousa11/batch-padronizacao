package config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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

import model.Codigo;
import steps.PadronizacaoProcessor;
import steps.PadronizacaoReader;
import steps.PadronizacaoWriter;


@Configuration
public class PadronizacaoPecasJob {

	@Autowired private JobBuilderFactory jobBuilderFactory;

	@Autowired private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job padronizacarPecasJob(@Qualifier("pradronizarPecasStep") Step pradronizarPecasStep) {
		return jobBuilderFactory.get("padronizacarPecasJob")
				.incrementer(new RunIdIncrementer())
				.flow(pradronizarPecasStep)
				.end()
				.build();
	}
	
	@Bean
	public PadronizacaoReader reader() {
		return new PadronizacaoReader();
	}
	
	@Bean
	public PadronizacaoProcessor processor() {
		return new PadronizacaoProcessor();
	}
	
	@Bean
	public PadronizacaoWriter writer() {
		return new PadronizacaoWriter();
	}
	
	//VER SE OS GENERICS ESTÃO CORRETOS OU SE SÃO NECESSÁRIOS
	@Bean
	public Step pradronizarPecasStep(ItemReader padronizacaoReader,
			ItemProcessor padronizacaoProcessor,
			ItemWriter padronizacaoWriter 
			) {
		return stepBuilderFactory.get("pradronizarPecasStep")
				.<Codigo,Codigo>chunk(10)
				.reader(padronizacaoReader)
				.processor(padronizacaoProcessor)
				.writer(padronizacaoWriter)
				.build();
	}
	
}
