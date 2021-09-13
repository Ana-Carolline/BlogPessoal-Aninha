package org.generation.BlogPessoal.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe utilizada como Entidade no Banco de dados para Postagem, a mesma
 * possui atributos que seram colunas no banco com titulo : titulo, descricao
 * 
 * @author Turma 29
 * @since 1.0
 */
@Entity
@Table (name = "tb_postagem")
public class postagem {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@Size (min = 5 , max = 50)
	private String titulo;
	
	@NotBlank
	@Size (min = 10, max = 500)
	private String texto;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "criador_id")
	@JsonIgnoreProperties({"minhasPostagens"})
	private usuario criador;
	
	@ManyToOne
	@JoinColumn(name = "tema_id")
	@JsonIgnoreProperties({"postagens"})
	private tema temaRelacionado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public usuario getCriador() {
		return criador;
	}
	public void setCriador(usuario criador) {
		this.criador = criador;
	}
	public tema getTemaRelacionado() {
		return temaRelacionado;
	}
	public void setTemaRelacionado(tema temaRelacionado) {
		this.temaRelacionado = temaRelacionado;
	}
	
	
}
