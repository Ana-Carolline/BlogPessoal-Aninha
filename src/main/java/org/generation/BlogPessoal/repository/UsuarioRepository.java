package org.generation.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BlogPessoal.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Long> {
	
	/**
	 * Método utilizado para pesquisar coluna nome ContainigIgnoreCase
	 * 
	 * @param nome do tipo String
	 * @return List de Usuarios
	 * @author Dev Ana Carolline
	 * @since 1.0
	 * 
	 */
	
	List<usuario> findAllByNomeContainingIgnoreCase (String nome);
	
	/**
	 * Método utilizado para pesquisar coluna email
	 * 
	 * @param email do tipo String
	 * @return Optional com Usuario
	 * @author Dev Ana Carolline
	 * @since 1.0
	 * 
	 */
	Optional<usuario> findByEmail (String email);

}
