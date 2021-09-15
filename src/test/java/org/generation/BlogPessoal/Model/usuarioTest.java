package org.generation.BlogPessoal.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.generation.BlogPessoal.model.usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class usuarioTest {

	public usuario Usuario;
	public usuario usuarioNulo = new usuario();
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validador = factory.getValidator();

	@BeforeEach
	void start() {
		Usuario = new usuario(0L, "Ana Carolline", "anacarolline@gmail.com", "123456");
	}
	
	@Test
	@DisplayName("✔ Valida atributos não Nulos")
	void validaUsuarioComAtributosNaoRetornaErro() {
		Set<ConstraintViolation<usuario>> violacao = validador.validate(Usuario);
		System.out.println(violacao.toString());
		
		assertTrue(violacao.isEmpty());

	}
	
	@Test
	@DisplayName("❌ Não Valida atributos Nulos")
	void validaUsuarioComAtributosRetornaErro() {
		Set<ConstraintViolation<usuario>> violacao = validador.validate(usuarioNulo);
		System.out.println(violacao.toString());
		
		assertFalse(violacao.isEmpty());

	}

}
	

