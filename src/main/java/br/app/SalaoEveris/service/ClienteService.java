package br.app.SalaoEveris.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.repository.ClienteRepository;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ListClienteResponse;
import br.app.SalaoEveris.response.ClienteResponse;
import br.app.SalaoEveris.request.ClienteRequest;

@Service
public class ClienteService {

	final ClienteRepository _repository;
	
	@Autowired
	private ClienteService (ClienteRepository repository){
		_repository = repository;
	}
		
	

	public BaseResponse inserir(ClienteRequest clientRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new ClienteResponse();
		base.StatusCode = 400;

		if (clientRequest.getNome() == "" || clientRequest.getNome() == null) {
			base.Message = "Nome do cliente não informado!";
			return base;
		}
		if (clientRequest.getCpf() == "" || clientRequest.getCpf() == null) {
			base.Message = "CPF do cliente não informado!";
			return base;
		}
		if (clientRequest.getEndereco() == "" || clientRequest.getEndereco() == null) {
			base.Message = "Endereço do cliente não informado!";
			return base;
		}
		if (clientRequest.getTelefone() == "" || clientRequest.getTelefone() == null) {
			base.Message = "Telefone do cliente não informado!";
			return base;
		}
		
		cliente.setNome(clientRequest.getNome());
		cliente.setCpf(clientRequest.getCpf());
		cliente.setEndereco(clientRequest.getEndereco());
		cliente.setTelefone(clientRequest.getTelefone());
		
		_repository.save(cliente);
		
		base.StatusCode= 201;
		base.Message= "Cliente inserido com sucesso!";
		return base;
		
	}

	public ClienteResponse obter(Long id) {

		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();

		if (cliente.isEmpty()) {
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}
		

		if (cliente.isEmpty()) {
			response.Message = "Id não encontrado";
			response.StatusCode = 400;
			return response;
		}
		
		response.setNome(cliente.get().getNome());
		response.setEndereco(cliente.get().getEndereco());
		response.setTelefone(cliente.get().getTelefone());
		response.Message = "Cliente obtido com sucesso!";
		response.StatusCode = 200;
		
		return response;
		
		
	}

	public ListClienteResponse listar() {

		List<Cliente> lista = _repository.findAll();
		
		List<ClienteResponse> clienteResponse = new ArrayList<ClienteResponse>();
		
		for(Cliente cliente : lista) {
			ClienteResponse clienteResponseList = new ClienteResponse();
			
			clienteResponseList.setNome(cliente.getNome());
			clienteResponseList.setEndereco(cliente.getEndereco());
			clienteResponseList.setTelefone(cliente.getTelefone());
			clienteResponseList.setId(cliente.getId());
			
			clienteResponse.add(clienteResponseList);
			
		}
		
		ListClienteResponse response = new ListClienteResponse();
		response.setClientes(clienteResponse);
		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso";

		return response;

	}

}
