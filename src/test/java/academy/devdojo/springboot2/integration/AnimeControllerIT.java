package academy.devdojo.springboot2.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.util.AnimeCreator;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class AnimeControllerIT {
	
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @LocalServerPort
    private int port;
   
    @Autowired
    private AnimeRepository animeRepository;
   
    @Test
    @DisplayName("list returns list of anime inside page object when successful")
    void list_ReturnsListOfAnimesInsidePageObject_WhenSuccessful(){
        Anime savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());

        String expectedName = savedAnime.getName();

//        PageableResponse<Anime> animePage = testRestTemplate.exchange("/animes", HttpMethod.GET, null,
//                new ParameterizedTypeReference<PageableResponse<Anime>>() {
//                }).getBody();
//
//        Assertions.assertThat(animePage).isNotNull();
//
//        Assertions.assertThat(animePage.toList())
//                .isNotEmpty()
//                .hasSize(1);
//
//        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

}
