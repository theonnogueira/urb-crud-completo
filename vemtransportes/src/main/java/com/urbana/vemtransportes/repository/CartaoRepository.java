package com.urbana.vemtransportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbana.vemtransportes.model.Cartao;

@Repository // Anotação para indicar que a interface faz referencia a um repositório
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	public List<Cartao> findAllByNomeContainingIgnoreCase(String nome); //Talvez eu altere para buscar através do nome;

}
