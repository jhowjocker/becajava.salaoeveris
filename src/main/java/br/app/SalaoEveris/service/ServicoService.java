package br.app.SalaoEveris.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.model.Servico;
import br.app.SalaoEveris.repository.ServicoRepository;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ListServicoResponse;
import br.app.SalaoEveris.response.ServicoResponse;
import br.app.SalaoEveris.request.ServicoRequest;

@Service
public class ServicoService {

	@Autowired
	private  ServicoRepository repository;
	
	public BaseResponse inserir(ServicoRequest servicoRequest) {
		Servico servico = new Servico();
		BaseResponse base = new ServicoResponse();
		base.StatusCode = 400;

		if (servicoRequest.getNome() == "" || servicoRequest.getNome() == null) {
			base.Message = "Tipo de serviço não informado!";
			base.StatusCode = 400;
			return base;
		}
		
		if (servicoRequest.getValor() <= 0) {
			base.Message = "Valor não informado!";
			base.StatusCode = 400;
			return base;
		}
		
		servico.setNome(servicoRequest.getNome());
		servico.setValor(servicoRequest.getValor());
		
		repository.save(servico);
		
		base.StatusCode= 201;
		base.Message= "Serviço inserido com sucesso!";
		return base;
	
	
	}
	


	public ServicoResponse obter(Long id) {

		Optional<Servico> servico = repository.findById(id);
		ServicoResponse response = new ServicoResponse();

		if (servico.isEmpty()) {
			response.Message = "ID Não informado!";
			response.StatusCode = 400;
			return response;
		}
		
		response.setId(id);
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		
		response.Message = "Cliente obtido com sucesso!";
		response.StatusCode = 200;
		
		return response;
		
		
	}

		public ListServicoResponse listar() {
		List<Servico> lista = repository.findAll();
		ListServicoResponse response = new ListServicoResponse();

		response.setServicos(lista);
		response.StatusCode = 200;
		response.Message = "Lista de servicos obtida.";

		return response;	
	

	}

}
