package de.neuefische.characters.models;

import de.neuefische.characters.models.api.RickAndMortyOrigin;

import java.util.List;

public record Character(

        String id,
        String name,
        String status,
        RickAndMortyOrigin origin,
        List<String> episode

){}