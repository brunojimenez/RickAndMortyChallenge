package cl.rymc.service.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * Clase que describe los errores de validacion.
 * 
 * @author Bruno Jimenez
 */
@Data
public class SubError implements Serializable {

	/**
	 * Serial de la clase.
	 */
	private static final long serialVersionUID = 4452841274793759045L;

	private String field;
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object rejectedValue;

	public SubError(String field, String message, Object rejectedValue) {

		super();
		this.field = field;
		this.message = message;
		this.rejectedValue = rejectedValue;

		if (this.rejectedValue instanceof String) {
			this.rejectedValue = ((String) rejectedValue).trim();
		}

	}

}
