package com.example.cadastro.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	//public List<Cadastro> findAllNomeContainingIgnoreCase (String nome);
	
	
}
