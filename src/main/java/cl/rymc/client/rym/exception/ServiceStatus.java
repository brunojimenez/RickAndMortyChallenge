package cl.rymc.client.rym.exception;

public enum ServiceStatus {

	BAD_REQUEST_INVALID_BODY_FIELD("24", "Invalid body field"), //
	BAD_REQUEST("400", "Bad Request"), //
	BAD_REQUEST_INVALID_URL_PARAMETER("20", "Invalid URL parameter value"), //
	UNSUPPORTED_MEDIA_TYPE("415", "Unsupported Media Type"), //
	EXCEEDS_MAX_LEN("452", "Exceeds Maximum Length"), //
	INTERNAL_SERVER_ERROR("500", "Internal Server Error"),

	VALIDACION_REQUEST("-100", "Atributos no validos"), //
	ERROR_INESPERADO("-200", "Error inesperado"), //
	ERROR_AL_PARCELAR_ID_LOCACION("-300", "Error al parcelar ID de la locacion"), //
	ERROR_RYM_CLIENT_LOCACION_NULA("-400", "Se obtuvo una locacion nula"), //
	ERROR_RYM_CLIENT_AL_CONSULTAR_LOCACION("-401", "Error al consulta locacion"), //
	ERROR_RYM_CLIENT_AL_CONSULTAR_LOCACION_INESPERADO("-402", "Error inesperado al consultar locacion"), //
	ERROR_RYM_CLIENT_CARACTER_NULO("-400", "Se obtuvo un caracter nul"), //
	ERROR_RYM_CLIENT_AL_CONSULTAR_CARACTER("-402", "Error al consulta caracter"), //
	ERROR_RYM_CLIENT_AL_CONSULTAR_CARACTER_INESPERADO("-403", "Error inesperado al consultar caracter"), //

	;

	/**
	 * Codigo del estado de la operacion.
	 */
	private final String code;

	/**
	 * Descripcion del estado de la operacion.
	 */
	private final String message;

	private ServiceStatus(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
