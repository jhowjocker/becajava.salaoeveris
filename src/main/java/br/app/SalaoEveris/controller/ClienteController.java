package br.app.SalaoEveris.controller;

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

import br.app.SalaoEveris.model.*;
import br.app.SalaoEveris.request.ClienteRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ListClienteResponse;
import br.app.SalaoEveris.response.ClienteResponse;
import br.app.SalaoEveris.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController{
	@Autowired
	private ClienteService service;
	
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody ClienteRequest clienteRequest) {
		try {
			
			BaseResponse response = service.inserir(clienteRequest);
			
			return ResponseEntity.status(response.StatusCode).body(response);
			
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Cliente não encontrado");
	}
	}
		
	@GetMapping(path ="/{id}")
	
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			ClienteResponse response = service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
			
		}
	}
	
	@GetMapping
	public ResponseEntity listar() {
		
		try {
			ListClienteResponse response = service.listar();
			return ResponseEntity.status(response.StatusCode).body(response);
		}catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

}

















