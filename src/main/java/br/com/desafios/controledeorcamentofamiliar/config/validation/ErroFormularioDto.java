package br.com.desafios.controledeorcamentofamiliar.config.validation;

public class ErroFormularioDto {// essa classe vai representar o erro, a mensagem de erro personalizada
	
	private String status; // campo do erro
	private String erro; // qual erro foi gerado
	private String message;
	
	public ErroFormularioDto() {
		// TODO Auto-generated constructor stub
	}
	public ErroFormularioDto(String status, String erro, String message) {
		super();
		this.status = status;
		this.erro = erro;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 
	
	
	

}
