package cl.rymc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.rymc.client.rym.RickAndMortyApi;
import cl.rymc.client.rym.exception.GetCharacterException;
import cl.rymc.client.rym.exception.GetLocationException;
import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.CharacterLocation;
import cl.rymc.client.rym.to.Location;
import cl.rymc.exception.RickAndMortyChallengeServiceException;
import cl.rymc.service.to.CharacterResponse;
import cl.rymc.service.to.Mapper;
import cl.rymc.service.to.Origin;

/**
 * Implementacion de las operaciones de negocio.
 * 
 * @author Bruno Jimenez
 */
@Service
public class RickAndMortyChallengeServiceImpl implements RickAndMortyChallengeService {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(RickAndMortyChallengeServiceImpl.class);

	@Autowired
	private RickAndMortyApi rickAndMortyApi;

	/**
	 * Metodo de negocio que obtiene un caracter.
	 */
	public CharacterResponse getCharacter(Integer id) throws Exception {
		logger.info("[getCharacter] Inicio (id={})", id);

		try {

			Character character = rickAndMortyApi.getSingleCharacter(id);
			logger.info("[getSingleCharacter] getSingleCharacter OK");

			CharacterLocation characterLocation = character.getLocation();
			Integer locationId = getLocationId(characterLocation);

			Location location = rickAndMortyApi.getSingleLocation(locationId);
			logger.info("[getSingleCharacter] getSingleLocation OK");

			List<String> episodes = character.getEpisode();

			// Previene nullpointer
			Integer episodeCount = 0;
			if (episodes != null) {
				episodeCount = episodes.size();
			}

			// Prepara la respuesta
			CharacterResponse characterResponse = Mapper.character2CharacterResponse(character);
			Origin origin = Mapper.location2Origin(location);
			characterResponse.setOrigin(origin);
			characterResponse.setEpisode_count(episodeCount);

			return characterResponse;
		} catch (GetCharacterException | GetLocationException e) {
			throw e;
		} catch (Exception e) {
			throw new RickAndMortyChallengeServiceException();
		}

	}

	/**
	 * Retorna el identificador de la locacion a partir de un objeto de
	 * CharacterLocation.
	 * 
	 * @param characterLocation
	 * @return
	 * @throws RickAndMortyChallengeServiceException
	 */
	private Integer getLocationId(CharacterLocation characterLocation) throws RickAndMortyChallengeServiceException {

		String locationUrl = characterLocation.getUrl();
		String[] locationSplit = locationUrl.split("/");

		if (locationSplit.length == 0) {
			// TODO Lanzar excepcion por que no logró parcelar el ID de la locacion
			throw new RickAndMortyChallengeServiceException();
		}

		// Obtiene el ID de la ubicacion
		// https://rickandmortyapi.com/api/location/20
		String strLocationId = locationSplit[locationSplit.length - 1];
		Integer locationId = Integer.parseInt(strLocationId);
		logger.info("[getLocationId] locationId={}", locationId);

		return locationId;
	}

}
