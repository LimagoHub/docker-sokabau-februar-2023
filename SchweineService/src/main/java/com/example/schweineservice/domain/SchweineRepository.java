package com.example.schweineservice.domain;

import com.example.schweineservice.domain.model.Schwein;

import java.util.Optional;

public interface SchweineRepository {

    public void speichern(Schwein schwein);
    public void aendern(Schwein schwein);

    public boolean loeschen(String id);
    public Optional<Schwein> sucheNachId(String id);

    public Iterable<Schwein> sucheAlle();

    public boolean exist(String id);
}
