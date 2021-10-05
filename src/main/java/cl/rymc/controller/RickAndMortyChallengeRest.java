package cl.rymc.controller;

import org.springframework.http.ResponseEntity;

import cl.rymc.service.to.CharacterResponse;

public interface RickAndMortyChallengeRest {

	public ResponseEntity<CharacterResponse> getCharacter(Integer id) throws Exception;

}
