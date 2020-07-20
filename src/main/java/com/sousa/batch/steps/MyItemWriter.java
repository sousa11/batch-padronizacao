package com.sousa.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sousa.batch.mapper.PecasMapper;
import com.sousa.batch.model.Codigo;

@Component
public class MyItemWriter implements ItemWriter<List<Codigo>>{

	@Autowired
	private PecasMapper pecasMapper;
	
	@Override
	public void write(List<? extends List<Codigo>> lista) throws Exception {

		for (List<Codigo> listaUpdate : lista) {
			for (Codigo parametros : listaUpdate) {
				pecasMapper.updateCodigos(parametros.getCodigo(), parametros.getCodigoantigo(), parametros.getIdpecas());
			}
		}
	}
}
