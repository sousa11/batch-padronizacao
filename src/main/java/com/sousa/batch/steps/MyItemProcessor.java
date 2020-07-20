package com.sousa.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sousa.batch.model.Codigo;

@Component
public class MyItemProcessor implements ItemProcessor<List<Codigo>, List<Codigo>>{

	@Override
	public List<Codigo> process(List<Codigo> lista) throws Exception {
		
		for (Codigo codigo : lista) {
			if(codigo.getCodigo().contains("/") || codigo.getCodigo().trim().contains(" ") || codigo.getCodigo().contains("-")){
				
				codigo.setCodigoantigo(codigo.getCodigo());
				codigo.setCodigo(codigo.getCodigoantigo().replaceAll("[/ -]", "").trim());
			}
		}
		
		return lista;
	}

}
