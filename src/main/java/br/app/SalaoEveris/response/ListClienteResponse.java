package br.app.SalaoEveris.response;

import java.util.List;
import br.app.SalaoEveris.model.*;

public class ListClienteResponse extends BaseResponse {
	
	private List<ClienteResponse> Clientes;

	public List<ClienteResponse> getClientes() {
		return Clientes;
	}

	public void setClientes(List<ClienteResponse> clientes) {
		Clientes = clientes;
	}


	
	
}
