package com.urbana.vemtransportes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbana.vemtransportes.model.Usuario;
import com.urbana.vemtransportes.model.UsuarioLogin;
import com.urbana.vemtransportes.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
}
//	@Autowired
//	public UsuarioRepository repository;
//
//	@GetMapping
//	public ResponseEntity<List<Usuario>> GetAll() {
//		return ResponseEntity.ok(repository.findAll());
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<Usuario> GetById(@PathVariable long id) {
//		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
//	}
//
//	@PostMapping
//	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
//	}
//
//	@PutMapping
//	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario) {
//		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable long id) {
//		repository.deleteById(id);
//	}
//}
