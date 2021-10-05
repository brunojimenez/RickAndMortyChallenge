package cl.rymc.service.to;

import lombok.Data;

@Data
public class CharacterResponse {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private Integer episode_count;
	private Origin origin;

}