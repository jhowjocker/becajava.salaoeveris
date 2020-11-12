package br.app.SalaoEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.SalaoEveris.request.AgendamentoRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController extends BaseController {
	@Autowired
	private AgendamentoService service;

	@PostMapping
	public ResponseEntity <BaseResponse>inserir(@RequestBody AgendamentoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
}