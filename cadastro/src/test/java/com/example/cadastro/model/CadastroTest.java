package com.example.cadastro.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


//criar outra porta se a 8080 estiver indisponivel
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CadastroTest {

	
	//criar objetos para fazer os teste
	
	public Cadastro cadastro;
	public Cadastro cadastroNulo = new Cadastro();
	
	//criar lista com as validações da model 
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();
	
	@BeforeEach  // esse metodo será exacutado antes de qualquer teste
	public void start() {
		
		LocalDate data= LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		cadastro= new Cadastro(0L, " Juliana Alves", 1125871581L, data);
	}
	 @Test
	 void testValidaAtributos() {
		 
		Set<ConstraintViolation<Cadastro>> violacao = validator.validate(cadastro);
		
		System.out.println(violacao.toString());
		
		assertTrue(violacao.isEmpty());
	 }
	 
	 @Test
	 void testNaoValidaAtributos() {
		 
		Set<ConstraintViolation<Cadastro>> violacao = validator.validate(cadastroNulo);
		
		System.out.println(violacao.toString());
		
		assertFalse(violacao.isEmpty());
	 }
	
}


