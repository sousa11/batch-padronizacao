package com.sousa.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sousa.batch.mapper.PecasMapper;
import com.sousa.batch.model.Codigo;

@Component
public class MyItemReader implements ItemReader<List<Codigo>> {

	@Autowired
	private PecasMapper pecasMapper;
	
	@Override
	public List<Codigo> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException{
		
		final List<Codigo> lista = pecasMapper.selectCodigos(2);
		
		return lista;
	}

}
