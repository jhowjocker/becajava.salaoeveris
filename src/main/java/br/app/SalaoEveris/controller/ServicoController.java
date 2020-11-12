package br.app.SalaoEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.SalaoEveris.request.ClienteRequest;
import br.app.SalaoEveris.request.ServicoRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ListClienteResponse;
import br.app.SalaoEveris.response.ListServicoResponse;
import br.app.SalaoEveris.response.ServicoResponse;
import br.app.SalaoEveris.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {

	@Autowired
	private ServicoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody ServicoRequest servicoRequest) {
		try {

			BaseResponse response = service.inserir(servicoRequest);

			return ResponseEntity.status(response.StatusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Serviço não encontrado");
		}
	}
	
	@GetMapping (path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			ServicoResponse response = service.obter(id);

			return ResponseEntity.status(response.StatusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
	
	@GetMapping 
	public ResponseEntity Listar () {
		try {

			ListServicoResponse response = service.listar();

			return ResponseEntity.status(response.StatusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
	
	

}
