package cl.rymc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.rymc.service.RickAndMortyChallengeService;
import cl.rymc.service.to.CharacterResponse;

@RestController
public class RickAndMortyChallengeRestImpl implements RickAndMortyChallengeRest {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(RickAndMortyChallengeRestImpl.class);

	/**
	 * Servicio de negocio.
	 */
	@Autowired
	private RickAndMortyChallengeService service;

	/**
	 * Metodo que obtiene un caracter.
	 */
	@GetMapping("/getCharacter/{id}")
	public ResponseEntity<CharacterResponse> getCharacter(@PathVariable Integer id) throws Exception {
		logger.info("[getCharacter] Inicio (id={})", id);
		CharacterResponse character = service.getCharacter(id);
		logger.info("[getCharacter] Fin");
		return new ResponseEntity<>(character, HttpStatus.OK);
	}

}
