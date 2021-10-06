package cl.rymc.service.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ExceptionResponse implements Serializable {

	/**
	 * Serial de la clase.
	 */
	private static final long serialVersionUID = 4563821418712811787L;

	private String errorCode;

	private String errorMessage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<SubError> subErrors = new ArrayList<>();

	public void setValidationErrors(Errors errors) {
		List<FieldError> fieldErrors = errors.getFieldErrors();
		fieldErrors
				.forEach(f -> subErrors.add(new SubError(f.getField(), f.getDefaultMessage(), f.getRejectedValue())));
	}

}
