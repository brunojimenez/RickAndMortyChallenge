package cl.rymc.client.rym;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import cl.rymc.client.rym.exception.GetCharacterException;
import cl.rymc.client.rym.exception.GetLocationException;
import cl.rymc.client.rym.exception.ServiceStatus;
import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.Location;
import cl.rymc.service.to.SubError;

/**
 * Implementacion de las operaciones a utilizar de Rick And Morty Api.
 * 
 * @author Bruno Jimenez
 */
@Component
public class RickAndMortyApiImpl implements RickAndMortyApi {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(RickAndMortyApiImpl.class);

	private static final String API_CHARACTER_URL_KEY = "api.rickandmortyapi.character.url";

	private static final String API_LOCATION_URL_KEY = "api.rickandmortyapi.location.url";

	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Location getSingleLocation(Integer id) throws GetLocationException {
		logger.info("[getSingleLocation] Inicio (id={})", id);

		try {
			String propUrl = env.getProperty(API_LOCATION_URL_KEY);
			URI url = URI.create(propUrl + id);
			logger.info("[getSingleLocation] url={}", url);

			Location response = restTemplate.getForObject(url, Location.class);

			if (response == null) {
				throw new GetLocationException(ServiceStatus.ERROR_RYM_CLIENT_LOCACION_NULA);
			}

			logger.info("[getSingleLocation] response={}", response);

			return response;
		} catch (HttpClientErrorException e) {
			logger.error("[getSingleLocation] Error", e);
			List<SubError> subErrors = new ArrayList<>();
			subErrors.add(new SubError("ResponseBody", e.getResponseBodyAsString(), null));
			throw new GetLocationException(ServiceStatus.ERROR_RYM_CLIENT_AL_CONSULTAR_LOCACION, subErrors);
		} catch (Exception e) {
			logger.error("[getSingleLocation] Error", e);
			List<SubError> subErrors = new ArrayList<>();
			subErrors.add(new SubError("Message", e.getMessage(), null));
			throw new GetLocationException(ServiceStatus.ERROR_RYM_CLIENT_AL_CONSULTAR_LOCACION_INESPERADO);
		}

	}

	@Override
	public Character getSingleCharacter(Integer id) throws GetCharacterException {
		logger.info("[getSingleCharacter] Inicio (id={})", id);

		try {
			String propUrl = env.getProperty(API_CHARACTER_URL_KEY);

			URI url = URI.create(propUrl + id);
			logger.info("[getSingleCharacter] url={}", url);

			Character response = restTemplate.getForObject(url, Character.class);

			if (response == null) {
				throw new GetCharacterException(ServiceStatus.ERROR_RYM_CLIENT_CARACTER_NULO);
			}

			logger.info("[getSingleCharacter] response={}", response);
			return response;
		} catch (HttpClientErrorException e) {
			logger.error("[getSingleCharacter] Error", e);
			List<SubError> subErrors = new ArrayList<>();
			subErrors.add(new SubError("ResponseBody", e.getResponseBodyAsString(), null));
			throw new GetCharacterException(ServiceStatus.ERROR_RYM_CLIENT_AL_CONSULTAR_CARACTER, subErrors);
		} catch (Exception e) {
			logger.error("[getSingleCharacter] Error", e);
			List<SubError> subErrors = new ArrayList<>();
			subErrors.add(new SubError("ResponseBody", e.getMessage(), null));
			throw new GetCharacterException(ServiceStatus.ERROR_RYM_CLIENT_AL_CONSULTAR_CARACTER_INESPERADO, subErrors);
		}
	}

}
