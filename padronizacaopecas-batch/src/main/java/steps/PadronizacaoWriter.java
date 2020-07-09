package steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import model.Codigo;

//@Component("padronizacaoWriter")
public class PadronizacaoWriter implements ItemWriter<Codigo>{

	@Override
	public void write(List<? extends Codigo> codigo) throws Exception {
		System.out.println("PASSANDO PELO WRITER");
	}

}
