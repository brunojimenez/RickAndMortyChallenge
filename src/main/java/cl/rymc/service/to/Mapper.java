package cl.rymc.service.to;

import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.Location;

/**
 * Clase que mapea atributos de un objeto a otro.
 * 
 * @author Bruno Jimenez
 */
public class Mapper {

	public static CharacterResponse character2CharacterResponse(Character character) {

		CharacterResponse characterResponse = new CharacterResponse();

		characterResponse.setId(character.getId());
		characterResponse.setName(character.getName());
		characterResponse.setStatus(character.getStatus());
		characterResponse.setSpecies(character.getSpecies());
		characterResponse.setType(character.getType());

		return characterResponse;
	}

	public static Origin location2Origin(Location location) {

		Origin origin = new Origin();
		origin.setName(location.getName());
		origin.setUrl(location.getUrl());
		origin.setDimension(location.getDimension());
		origin.setResidents(location.getResidents());

		return origin;
	}

}
