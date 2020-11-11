package br.app.SalaoEveris.controller;

import br.app.SalaoEveris.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.StatusCode = 500;
		errorBase.Message = "ERRO inesperado. Contate o ADM";

	}

}
