package de.neuefische.characters.models.api;

import de.neuefische.characters.models.Character;

import java.util.List;

public record RickAndMortyResponse(
        RickAndMortyInfo info,
        List<Character> results
) {
}
