package com.sousa.batch.steps;

import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sousa.batch.mapper.PecasMapper;
import com.sousa.batch.model.Codigo;

@Component
public class TesteTasklet implements Tasklet{

	@Autowired
	private PecasMapper pecasMapper;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		final List<Codigo> lista = pecasMapper.selectCodigos(1);
		
		for (Codigo codigo : lista) {
			System.out.println(codigo.getCodigo());
		}

		System.out.println("\n\t\t\t\t\t\t\t##### TESTE REALIZADO COM SUCESSO #####\n");
		
		return RepeatStatus.FINISHED;
	}

}
