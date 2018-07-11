package br.com.cflima.semijoias.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cflima.semijoias.model.Peca;

@Repository
public interface IPecaRepository extends CrudRepository<Peca, Long>{
	
//	@Query(value = "FROM peca WHERE marca = :marcaId")
//	List<Peca> findByMarcaId(@Param("marcaId") Long id);

	@Query(value = "FROM peca p WHERE p.marca.id = :marcaId and p.valor = :valor")
	Peca findPecaByValorEMarca(@Param("marcaId")Long marcaId, @Param("valor")Float valor);
}
