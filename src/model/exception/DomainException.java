package model.exception;

public class DomainException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	// Exemplo de uso de uma exce��o criada
	public DomainException() {
		super();
	}
	
	public DomainException(String msg) {
		super(msg);
	}
}
