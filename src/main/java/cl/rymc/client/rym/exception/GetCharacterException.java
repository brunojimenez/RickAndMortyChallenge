package cl.rymc.client.rym.exception;

import java.util.List;

import cl.rymc.exception.ServiceException;
import cl.rymc.service.to.SubError;

public class GetCharacterException extends ServiceException {

	/**
	 * Serial de la clase.
	 */
	private static final long serialVersionUID = 1L;

	public GetCharacterException(ServiceStatus code) {
		super(code);
	}

	public GetCharacterException(ServiceStatus code, List<SubError> subErrors) {
		super(code, subErrors);
	}

}
