package com.sousa.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.sousa.batch.model.Codigo;
	
@Mapper
public interface PecasMapper {

	public final static String BATCH_PADRONIZACAO_SELECT = "SELECT * FROM kpecas WHERE modelo = #{numerocod}";
	
	public final static String BATCH_PADRONIZACAO_UPDATE = "UPDATE kpecas SET codigo = #{cod1}, codigoantigo = #{cod2} WHERE idpecas = #{cod3}";
	
	@Select(BATCH_PADRONIZACAO_SELECT)
	@Results({
		@Result(property = "codigo", column = "codigo"),
		@Result(property = "idpecas", column = "idpecas")
	})
	List<Codigo> selectCodigos (@Param("numerocod") int modelo);
	
	@Update(BATCH_PADRONIZACAO_UPDATE)
	void updateCodigos(@Param("cod1") String codigo, @Param("cod2") String codigoAntigo, @Param("cod3") int idpecas);
}

