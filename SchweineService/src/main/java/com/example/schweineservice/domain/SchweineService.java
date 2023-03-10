package com.example.schweineservice.domain;

import com.example.schweineservice.domain.model.Schwein;

import java.util.Optional;

public interface SchweineService {

    public void speichern(Schwein schwein);
    public void aendern(Schwein schwein);

    public boolean loeschen(String id);

    public boolean loeschen(Schwein schwein);

    public Optional<Schwein> sucheNachId(String id);

    public Iterable<Schwein> sucheAlle();

    public boolean fuettern(String id);
}
