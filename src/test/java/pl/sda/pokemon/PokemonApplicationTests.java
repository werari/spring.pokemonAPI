package pl.sda.pokemon;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import pl.sda.pokemon.dto.PokemonDto;


public class PokemonApplicationTests {

	@Test
	public void contextLoads() {
		CloseableHttpClient httpClient
				= HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory
				= new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

		PokemonDto pokemonDto= new RestTemplate(requestFactory).getForObject("https://pokeapi.co/api/v2/pokemon/1",PokemonDto.class);
		System.out.println(pokemonDto);
	}


}
