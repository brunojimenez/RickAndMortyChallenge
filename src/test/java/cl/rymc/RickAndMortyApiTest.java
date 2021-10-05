package cl.rymc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import cl.rymc.client.rym.RickAndMortyApiImpl;
import cl.rymc.client.rym.exception.GetCharacterException;
import cl.rymc.client.rym.exception.GetLocationException;
import cl.rymc.client.rym.to.Character;
import cl.rymc.client.rym.to.Location;

@SpringBootTest
class RickAndMortyApiTest {

	@InjectMocks
	private RickAndMortyApiImpl rickAndMortyApi;

	@Mock
	private Environment env;

	@Mock
	private RestTemplate restTemplate;

	@Test
	void getSingleCharacterTest() throws GetCharacterException {
		Character character = new Character();
		Mockito.when(env.getProperty(ArgumentMatchers.anyString())).thenReturn("");
		Mockito.when(restTemplate.getForObject(ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(Character.class)))
				.thenReturn(character);
		assertNotNull(rickAndMortyApi.getSingleCharacter(1));
	}

	@Test
	void getSingleLocationTest() throws GetLocationException {
		Location location = new Location();
		Mockito.when(env.getProperty(ArgumentMatchers.anyString())).thenReturn("");
		Mockito.when(restTemplate.getForObject(ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(Location.class)))
				.thenReturn(location);
		assertNotNull(rickAndMortyApi.getSingleLocation(1));
	}

	@Test
	void getCharacterExceptionTest() {
		assertThrows(GetCharacterException.class, () -> {
			Mockito.when(env.getProperty(ArgumentMatchers.anyString())).thenReturn("");
			Mockito.when(
					restTemplate.getForObject(ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(Character.class)))
					.thenThrow(HttpServerErrorException.class);
			rickAndMortyApi.getSingleCharacter(1);
		});

	}

	@Test
	void getLocationExceptionTest() {
		assertThrows(GetLocationException.class, () -> {
			Mockito.when(env.getProperty(ArgumentMatchers.anyString())).thenReturn("");
			Mockito.when(
					restTemplate.getForObject(ArgumentMatchers.any(URI.class), ArgumentMatchers.eq(Location.class)))
					.thenThrow(HttpServerErrorException.class);
			rickAndMortyApi.getSingleLocation(1);
		});
	}

}
