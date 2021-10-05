package cl.rymc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cl.rymc.service.RickAndMortyChallengeServiceImpl;
import cl.rymc.service.to.CharacterResponse;

@SpringBootTest
class RickAndMortyChallengeRestTests {

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private RickAndMortyChallengeServiceImpl service;

	private MockMvc mvc;

	@BeforeEach
	void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	void normalFlow() throws Exception {
		String url = "/getCharacter/1";
		CharacterResponse characterResponse = new CharacterResponse();
		Mockito.when(service.getCharacter(ArgumentMatchers.anyInt())).thenReturn(characterResponse);
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

}
