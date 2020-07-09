package steps;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import mapper.PadronizacaoMapper;
import model.Codigo;


//@Component(value="padronizacaoReader")
public class PadronizacaoReader implements ItemReader<Codigo>{

	@Autowired
	private PadronizacaoMapper padronizacaoMapper;
	
	@Override
	public Codigo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		
		
		padronizacaoMapper.selectCodigos(12);
		
		return null;
	}
	
	
}
