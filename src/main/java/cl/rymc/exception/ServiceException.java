package cl.rymc.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import cl.rymc.client.rym.exception.ServiceStatus;
import cl.rymc.service.to.SubError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException implements Serializable {

	/**
	 * Serial de la clase.
	 */
	private static final long serialVersionUID = 2911098799907883481L;

	protected static final String ERROR_DE_NEGOCIO = "Error de negocio.";

	protected final String errorCode;

	protected final String errorMessage;

	protected List<SubError> subErrors = new ArrayList<>();

	/**
	 * Estado http para manejar respuestas de la API.
	 */
	protected final HttpStatus httpStatus;

	public ServiceException(ServiceStatus code) {
		super(ERROR_DE_NEGOCIO);
		this.errorCode = code.getCode();
		this.errorMessage = code.getMessage();
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public ServiceException(ServiceStatus code, List<SubError> subErrors) {
		super(ERROR_DE_NEGOCIO);
		this.errorCode = code.getCode();
		this.errorMessage = code.getMessage();
		this.subErrors = subErrors;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
