package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<tema, Long> {
	
	/**
	 * Método utilizado para pesquisar coluna tema ContainigIgnoreCase
	 * 
	 * @param nome do tipo String
	 * @return List de Temas
	 * @author Turma 29
	 */
	
	List<tema> findAllByTemaContainingIgnoreCase (String Tema);

}
