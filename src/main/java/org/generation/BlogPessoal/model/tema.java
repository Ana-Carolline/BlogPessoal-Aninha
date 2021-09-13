package org.generation.BlogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe utilizada como Entidade no Banco de dados para Tema, a mesma possui
 * atributos que seram colunas no banco com titulo : tema
 * 
 * @author Turma 29
 * @since 1.0
 */
@Entity
@Table (name = "tb_tema")
public class tema {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTema;
	
	@NotBlank
	private String tema;
	
	@OneToMany (mappedBy = "temaRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ({"temaRelacionado"})
	private List <postagem> postagens = new ArrayList<>();

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<postagem> postagens) {
		this.postagens = postagens;
	}
	
	
	
}
