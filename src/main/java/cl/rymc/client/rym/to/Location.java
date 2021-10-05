package cl.rymc.client.rym.to;

import java.util.List;

import lombok.Data;

/**
 * Clase que representa a una locacion.
 * 
 * @author Bruno Jimenez
 */
@Data
public class Location {

	private Integer id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents;
	private String url;
	private String created;

}
