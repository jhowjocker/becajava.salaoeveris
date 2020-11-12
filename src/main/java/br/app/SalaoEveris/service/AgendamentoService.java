package br.app.SalaoEveris.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.model.Agendamento;
import br.app.SalaoEveris.repository.AgendamentoRepository;
import br.app.SalaoEveris.request.AgendamentoRequest;
import br.app.SalaoEveris.response.BaseResponse;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repository;
	
	public BaseResponse inserir(AgendamentoRequest request) {
			Agendamento agendamento = new Agendamento();
			BaseResponse base = new BaseResponse();
			
			if(request.getData() == null){
				base.Message = "Data não preenchida. Digite a data";
				base.StatusCode = 400;
				return base;
				
			}
			if(request.getData() == null){
				base.Message = "ID não digitado. Digite o ID!";
				base.StatusCode = 400;
				return base;
			}
			if(request.getServico() == null){
				base.Message = "Serviço não digitado. Digite o serviço!";
				base.StatusCode = 400;
				return base;
			}
			
			agendamento.setData(request.getData());
			agendamento.setCliente(request.getCliente());
			agendamento.setServico(request.getServico());
			
			repository.save(agendamento);
			base.Message = "Agendado!";
			return base;
			
	}
	

}


















