package cl.rymc;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import cl.rymc.client.rym.RickAndMortyApiImpl;
import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.CharacterLocation;
import cl.rymc.client.rym.to.CharacterOrigin;
import cl.rymc.client.rym.to.Location;
import cl.rymc.exception.ServiceException;
import cl.rymc.service.RickAndMortyChallengeServiceImpl;
import cl.rymc.service.to.CharacterResponse;

@SpringBootTest
class RickAndMortyChallengeServiceTests {

	@InjectMocks
	private RickAndMortyChallengeServiceImpl service;

	@Mock
	private RickAndMortyApiImpl rickAndMortyApi;

	private static Character character;

	private static Location location;

	private static List<String> episodes;

	@BeforeAll
	public static void setUp() {
		CharacterOrigin origin = new CharacterOrigin();
		origin.setName("unknown");
		origin.setUrl("");

		CharacterLocation characterLocation = new CharacterLocation();
		characterLocation.setName("Worldender's lair");
		characterLocation.setUrl("https://rickandmortyapi.com/api/location/4");

		episodes = new ArrayList<String>();
		episodes.add("https://rickandmortyapi.com/api/episode/25");

		character = new Character();
		character.setId(10);
		character.setName("Alan Rails");
		character.setStatus("Dead");
		character.setSpecies("Human");
		character.setType("Superhuman (Ghost trains summoner)");
		character.setGender("Male");
		character.setOrigin(origin);
		character.setLocation(characterLocation);
		character.setImage("https://rickandmortyapi.com/api/character/avatar/10.jpeg");
		character.setEpisode(episodes);
		character.setUrl("https://rickandmortyapi.com/api/character/10");
		character.setCreated("2017-11-04T20:19:09.017Z");

		List<String> residents = new ArrayList<String>();
		residents.add("https://rickandmortyapi.com/api/character/10");
		residents.add("https://rickandmortyapi.com/api/character/81");
		residents.add("https://rickandmortyapi.com/api/character/208");
		residents.add("https://rickandmortyapi.com/api/character/226");
		residents.add("https://rickandmortyapi.com/api/character/340");
		residents.add("https://rickandmortyapi.com/api/character/362");
		residents.add("https://rickandmortyapi.com/api/character/375");
		residents.add("https://rickandmortyapi.com/api/character/382");
		residents.add("https://rickandmortyapi.com/api/character/395");

		location = new Location();
		location.setId(4);
		location.setName("Worldender's lair");
		location.setType("Planet");
		location.setDimension("unknown");
		location.setResidents(residents);
		location.setUrl("https://rickandmortyapi.com/api/location/4");
	}

	@Test
	void normalFlow() throws Exception {

		Mockito.when(rickAndMortyApi.getSingleCharacter(ArgumentMatchers.anyInt())).thenReturn(character);
		Mockito.when(rickAndMortyApi.getSingleLocation(ArgumentMatchers.anyInt())).thenReturn(location);

		Integer id = 1;
		CharacterResponse characterResponse = service.getCharacter(id);

		Assertions.assertNotNull(characterResponse);
		Assertions.assertEquals(characterResponse.getName(), character.getName());
		Assertions.assertNotNull(characterResponse.getOrigin());
		Assertions.assertEquals(characterResponse.getOrigin().getName(), location.getName());
		Assertions.assertEquals(characterResponse.getEpisode_count(), episodes.size());

	}

	@Test
	void getSingleCharacterReturnNull() throws Exception {

		assertThrows(ServiceException.class, () -> {
			Mockito.when(rickAndMortyApi.getSingleCharacter(ArgumentMatchers.anyInt())).thenReturn(null);
			Mockito.when(rickAndMortyApi.getSingleLocation(ArgumentMatchers.anyInt())).thenReturn(location);

			Integer id = 1;
			service.getCharacter(id);
		});

	}

	@Test
	void getSingleLocationReturnNull() throws Exception {

		assertThrows(ServiceException.class, () -> {
			Mockito.when(rickAndMortyApi.getSingleCharacter(ArgumentMatchers.anyInt())).thenReturn(character);
			Mockito.when(rickAndMortyApi.getSingleLocation(ArgumentMatchers.anyInt())).thenReturn(null);

			Integer id = 1;
			service.getCharacter(id);
		});

	}

}
