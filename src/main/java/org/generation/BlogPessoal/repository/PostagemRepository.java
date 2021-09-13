package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<postagem, Long> {
	
	/**
	 * Método utilizado para pesquisar coluna titulo ContainigIgnoreCase
	 * 
	 * @param titulo do tipo String
	 * @return List de Postagens
	 * @author Turma 29
	 */

	List<postagem> findAllByTituloContainingIgnoreCase (String titulo);
	

}
