package com.urbana.vemtransportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbana.vemtransportes.model.Cartao;
import com.urbana.vemtransportes.repository.CartaoRepository;

@RestController
@RequestMapping("/cartao") // Anotação para mapear a URL suportando os métodos GET,POST,PUT e DELETE;
@CrossOrigin("*") // Anotação para que qualquer ambiente front-end consiga consumir as funções e
					// metódos dessa classe;
public class CartaoController {

	@Autowired // Funciona como um tipo de extenção da interface de repositório, fazendo
				// ligação com o JpaRepository;
	private CartaoRepository repository;

	// IMPLEMENTAÇÃO DE MÉTODOS:

	@GetMapping // Método para fazer requisição/solicitação
	public ResponseEntity<List<Cartao>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") // Consumo testado no Postman //parametro do tipo Id
	public ResponseEntity<Cartao> GetById(@PathVariable long id) {// pathVariable define a variavel do caminho da URI
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build()); // Optional
																														// //findById
																														// vai
																														// la
																														// no
																														// repositorio
																														// e
																														// trás
																														// o
																														// resp
																														// do
																														// tipo
																														// id;
	}

	@GetMapping("/nome/{nome}") // subcaminho e atributo, API não dar duplicidade de EndPoints
	public ResponseEntity<List<Cartao>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Cartao> Post(@RequestBody Cartao cartao) {// anotação RequestBody mapeia como passar o recurso
																	// pelo corpo
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cartao));// Retornando um status de criado
																						// e depois salvando no
																						// repositorio;
	}

	@PutMapping
	public ResponseEntity<Cartao> Put(@RequestBody Cartao cartao) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cartao)); // Método para atualizar um dado,
																					// usando como identificador o id;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id); // O método delete não precisa retornar nada, então ele é do tipo void, indo
									// direto ao repositóro e executando o delete pelo id;
	}

}
