package de.neuefische.characters.services;

import de.neuefische.characters.models.Character;
import de.neuefische.characters.repositorys.CharacterRepository;
import de.neuefische.characters.api.RickAndMortyAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final RickAndMortyAPIService rickAndMortyAPIService;

    public List<Character> getAllCharacters() {

        List<Character> rickMortyCharacters = rickAndMortyAPIService.loadAllCharacters();
        List<Character> localCharacters = characterRepository.findAll();

        List<Character> allCharacters = new ArrayList<>();
        allCharacters.addAll(rickMortyCharacters);
        allCharacters.addAll(localCharacters);
        return allCharacters;
    }

    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character getCharacterById(String id) {
        Character character = rickAndMortyAPIService.loadCharacterById(id);
        characterRepository.save(character);
        return character;
    }

}
