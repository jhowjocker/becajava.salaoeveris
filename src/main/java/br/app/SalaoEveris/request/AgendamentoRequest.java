package br.app.SalaoEveris.request;

import java.time.LocalDate;
import java.util.Date;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;

public class AgendamentoRequest {

	private Date data;
	private Cliente cliente;
	private Servico servico;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
}
