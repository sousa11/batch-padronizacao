package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Codigo;


@Mapper
public interface PadronizacaoMapper {

	public final static String BATCH_PADRONIZACAO_SELECT = "SELECT codigo FROM cadastro WHERE modelo = #{numerocod}";
	
	public final static String BATCH_PADRONIZACAO_UPDATE = "UPDATE cadastro SET codigo = #{cod1} WHERE modelo = #{cod2}";
	
	@Select(BATCH_PADRONIZACAO_SELECT)
	@Results({
		@Result(property = "codigo", column = "codigo"),
	})
	List<Codigo> selectCodigos (@Param("numerocod") int modelo);
	
	@Update(BATCH_PADRONIZACAO_UPDATE)
	void updateCodigos(@Param("cod1") String codigo, @Param("cod2") int modelo);
}
