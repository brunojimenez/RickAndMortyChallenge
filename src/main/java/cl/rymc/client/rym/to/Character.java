package cl.rymc.client.rym.to;

import java.util.List;

import lombok.Data;

/**
 * Clase que representa a un caracter.
 * 
 * @author Bruno Jimenez
 */
@Data
public class Character {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private CharacterOrigin origin;
	private CharacterLocation location;
	private String image;
	private List<String> episode;
	private String url;
	private String created;

}
