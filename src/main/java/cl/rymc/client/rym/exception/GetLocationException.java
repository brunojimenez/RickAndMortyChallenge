package cl.rymc.client.rym.exception;

import java.util.List;

import cl.rymc.exception.ServiceException;
import cl.rymc.service.to.SubError;

public class GetLocationException extends ServiceException {

	/**
	 * Serial de la clase.
	 */

	private static final long serialVersionUID = 8543941780416674716L;

	public GetLocationException(ServiceStatus code) {
		super(code);
	}

	public GetLocationException(ServiceStatus code, List<SubError> subErrors) {
		super(code, subErrors);
	}

}
