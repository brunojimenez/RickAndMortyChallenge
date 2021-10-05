package cl.rymc.client.rym;

import cl.rymc.client.rym.exception.GetCharacterException;
import cl.rymc.client.rym.exception.GetLocationException;
import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.Location;

/**
 * Interface que define las operaciones a utilizar de Rick And Morty Api.
 * 
 * @author Bruno Jimenez
 */
public interface RickAndMortyApi {

	/**
	 * Get a single location You can get a single location by adding the id as a
	 * parameter: /location/3
	 * 
	 * https://rickandmortyapi.com/api/location/3
	 * 
	 * @param ids
	 * @return
	 * @throws GetLocationException
	 */
	public Location getSingleLocation(Integer id) throws GetLocationException;

	/**
	 * Get a single character You can get a single character by adding the id as a
	 * parameter: /character/2
	 * 
	 * https://rickandmortyapi.com/api/character/2
	 * 
	 * @param id
	 * @return
	 * @throws GetCharacterException
	 */
	public Character getSingleCharacter(Integer id) throws GetCharacterException;

}
