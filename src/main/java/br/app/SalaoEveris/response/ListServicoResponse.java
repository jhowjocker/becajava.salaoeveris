package br.app.SalaoEveris.response;

import java.util.List;
import br.app.SalaoEveris.model.*;

public class ListServicoResponse extends BaseResponse {
	
	private List<Servico> servicos;

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}


	
	
}