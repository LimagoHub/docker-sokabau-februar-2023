package com.example.schweineservice.domain.impl;

import com.example.schweineservice.domain.SchweineRepository;
import com.example.schweineservice.domain.SchweineService;
import com.example.schweineservice.domain.model.Schwein;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SchweineServiceImpl implements SchweineService {


    private final SchweineRepository repo;
    private final List<String> bloedeSchweine;
    @Override
    public void speichern(Schwein schwein) {
        pruefen(schwein);

        try {
            repo.speichern(schwein);
        } catch (Exception e) {
            throw new SchweineServiceException("Fehler im Service", e);
        }


    }

    private void pruefen(Schwein schwein) {
        validate(schwein);
        businessCheck(schwein);
    }

    private void businessCheck(Schwein schwein) {
        if(bloedeSchweine.contains(schwein.getName()))
            throw new SchweineServiceException("Ungueltiger Name");
    }


    private static void validate(Schwein schwein) {
        if(schwein == null)
            throw new SchweineServiceException("wert muss gesetzt sein");

        if(schwein.getName() == null || schwein.getName().length()  <2)
            throw new SchweineServiceException("Name ist zu kurz");
    }


    @Override
    public void aendern(Schwein schwein) {
        pruefen(schwein);
        repo.aendern(schwein);
    }

    @Override
    public boolean loeschen(String id) {
        if(repo.exist(id)){
            repo.loeschen(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean loeschen(Schwein schwein) {
        return loeschen(schwein.getId());
    }

    @Override
    public Optional<Schwein> sucheNachId(String id) {
        return repo.sucheNachId(id);
    }

    @Override
    public Iterable<Schwein> sucheAlle() {
        return repo.sucheAlle();
    }

    @Override
    public boolean fuettern(String id) {

        Optional<Schwein> schweinOptional = sucheNachId(id);
        if(schweinOptional.isEmpty()) return false;
        Schwein schwein = schweinOptional.get();
        schwein.fuettern();
        aendern(schwein);
        return true;
    }
}
