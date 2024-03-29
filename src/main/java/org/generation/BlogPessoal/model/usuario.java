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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Classe utilizada como Entidade no Banco de dados para Usuario, a mesma possui
 * atributos que seram colunas no banco com titulo : nome, email e senha
 * 
 * @author Dev Ana Carolline
 * @since 1.0
 */

@Entity
@Table (name = "tb_usuario")
public class usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	
	@NotBlank (message = "Necessario Nome")
	private String nome;
	
	@NotBlank(message = "Necessario Email")
	@Email (message = "Necessario Email")
	private String email;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "Minimo de 5 caracteres")
	private String senha;
	
	@OneToMany (mappedBy = "criador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ({"criador"})
	private List<postagem> minhasPostagens = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<postagem> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<postagem> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}
	

}
