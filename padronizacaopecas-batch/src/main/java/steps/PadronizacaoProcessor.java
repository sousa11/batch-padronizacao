package steps;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import model.Codigo;

//@Component("padronizacaoProcessor")
public class PadronizacaoProcessor implements ItemProcessor<Codigo, Codigo> {

	@Override
	public Codigo process(Codigo arg0) throws Exception {
		
		/*if (this.getCodigo_original().contains("/") || this.getCodigo_original().trim().contains(" ")
				|| this.getCodigo_original().contains("-")) {
			this.setCodigo_antigo(this.getCodigo_original());
			this.setCodigo_original(this.getCodigo_antigo().replaceAll("[/ -]", "").trim());
			System.out.println("C�digo antigo: " + this.getCodigo_antigo() + "  C�digo original: " + this.getCodigo_original());
			
			return this.getCodigo_original();
			}
		System.out.println("C�digo " + this.getCodigo_original().trim() + " n�o possui caracteres a serem removidos");
		return this.getCodigo_original();
	}*/

	return null;
}

}
