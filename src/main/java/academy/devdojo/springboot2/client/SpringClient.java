package academy.devdojo.springboot2.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {
	
	public static void main(String[] args) {
		ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,3);
		log.info(entity);
		
		Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,3);
		log.info(object);
		
		Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
		log.info(Arrays.toString(animes));
		
		ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		log.info(exchange.getBody());
		
		//postForObject
//		Anime kingdom = Anime.builder().name(("kingdom")).build();
//		Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes", kingdom, Anime.class);
//		log.info("saved anime {}", kingdomSaved);
		
		Anime samurai = Anime.builder().name(("samaruai atualizar")).build();
		ResponseEntity<Anime> exchangeSamuraiSaved = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.POST, new HttpEntity<>(samurai, createJsonHeader()), Anime.class);
		log.info("saved anime {}", exchangeSamuraiSaved.getBody());
		
		
		Anime animeToUpdate = exchangeSamuraiSaved.getBody();
		animeToUpdate.setName("samaruai atualizar 2");
		ResponseEntity<Void> samuraiChamplooUpdated = new RestTemplate().exchange("http://localhost:8080/animes", 
				HttpMethod.PUT, 
				new HttpEntity<>(animeToUpdate, createJsonHeader()), 
				Void.class);
		log.info("saved anime {}", samuraiChamplooUpdated);
		
		ResponseEntity<Void> samuraiChamplooDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}", 
				HttpMethod.DELETE, 
				null, 
				Void.class,
				animeToUpdate.getId());
		log.info("saved anime {}", samuraiChamplooDeleted);
		
	}
	
	private static HttpHeaders createJsonHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}

}
