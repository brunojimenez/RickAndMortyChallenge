package cl.rymc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import cl.rymc.client.rym.exception.ServiceStatus;
import cl.rymc.exception.ServiceException;
import cl.rymc.service.to.ExceptionResponse;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(RestControllerExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(ServiceStatus.INTERNAL_SERVER_ERROR.getCode());
		response.setErrorMessage(ServiceStatus.INTERNAL_SERVER_ERROR.getMessage());
		logger.error("[handleAllExceptions] Error=", e);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(ServiceStatus.BAD_REQUEST.getCode());
		exceptionResponse.setErrorMessage(ServiceStatus.BAD_REQUEST.getMessage());
		logger.error("[InvalidFormatException] Error procesando solicitud: ", ex);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidFormatException.class)
	public ResponseEntity<ExceptionResponse> invalidFormatExceptionInput(InvalidFormatException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(ServiceStatus.BAD_REQUEST.getCode());
		exceptionResponse.setErrorMessage(ServiceStatus.BAD_REQUEST.getMessage());
		logger.error("[InvalidFormatException] Error procesando solicitud: ", ex);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(ServiceStatus.BAD_REQUEST_INVALID_URL_PARAMETER.getCode());
		response.setErrorMessage(ServiceStatus.BAD_REQUEST_INVALID_URL_PARAMETER.getMessage());
		logger.error("[MethodArgumentTypeMismatchException] Error=", ex);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(ServiceStatus.VALIDACION_REQUEST.getCode());
		response.setErrorMessage(ServiceStatus.VALIDACION_REQUEST.getMessage());
		response.setValidationErrors(e.getBindingResult());
		logger.error("[MethodArgumentNotValidException] Error=", e);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> mediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(ServiceStatus.UNSUPPORTED_MEDIA_TYPE.getCode());
		response.setErrorMessage(ServiceStatus.UNSUPPORTED_MEDIA_TYPE.getMessage());
		logger.error("[HttpMediaTypeNotSupportedException] Error=", e);
		return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<ExceptionResponse> negocioException(ServiceException e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(e.getErrorCode());
		exceptionResponse.setErrorMessage(e.getErrorMessage());
		exceptionResponse.setSubErrors(e.getSubErrors());
		logger.error("[ServiceException] Error =", e);
		return new ResponseEntity<>(exceptionResponse, e.getHttpStatus());
	}

}
