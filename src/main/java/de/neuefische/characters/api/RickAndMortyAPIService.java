package de.neuefische.characters.api;

import de.neuefische.characters.exception.CharacterNotFoundException;
import de.neuefische.characters.models.Character;
import de.neuefische.characters.models.api.RickAndMortyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyAPIService {

    private final RestClient restClient;

    public RickAndMortyAPIService(@Value("${app.rickandmorty.api.url}") String url) {
        restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    public List<Character> loadAllCharacters() {
        RickAndMortyResponse responseBody = restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyResponse.class);
        return responseBody.results();
    }

    public Character loadCharacterById(String id) {
        try {
            return restClient.get()
                    .uri("/character/" + id)
                    .retrieve()
                    .body(Character.class);
        }
        catch (HttpClientErrorException exception) {
            throw new CharacterNotFoundException(exception.getMessage());
        }
    }



}
