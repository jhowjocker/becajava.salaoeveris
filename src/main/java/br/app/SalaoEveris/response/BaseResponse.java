package br.app.SalaoEveris.response;

import javax.persistence.Transient;

public class BaseResponse {
	
	@Transient
	public int StatusCode;
	@Transient
	public String Message;

}