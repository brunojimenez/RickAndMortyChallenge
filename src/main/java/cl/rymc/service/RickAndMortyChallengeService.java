package cl.rymc.service;

import cl.rymc.service.to.CharacterResponse;

/**
 * Definicion de las operaciones de negocio.
 * 
 * @author Bruno Jimenez
 */
public interface RickAndMortyChallengeService {

	public CharacterResponse getCharacter(Integer id) throws Exception;

}
