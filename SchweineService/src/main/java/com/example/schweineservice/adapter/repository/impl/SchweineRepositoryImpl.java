package com.example.schweineservice.adapter.repository.impl;


import com.example.schweineservice.adapter.mapper.SchweinMapper;
import com.example.schweineservice.adapter.repository.raw.SchweineRawRepository;
import com.example.schweineservice.domain.SchweineRepository;
import com.example.schweineservice.domain.model.Schwein;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor

public class SchweineRepositoryImpl implements SchweineRepository {
    private final SchweineRawRepository raw;
    private final SchweinMapper mapper;

    @Override


    public void speichern(Schwein schwein) {
        raw.save(mapper.convert(schwein));
    }



    @Override
    public void aendern(Schwein schwein) {
        raw.save(mapper.convert(schwein));
    }

    @Override
    public boolean loeschen(String id) {
        if(raw.existsById(id)){
            raw.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public Optional<Schwein> sucheNachId(String id) {
        return raw.findById(id).map(mapper::convert);
    }

    @Override
    public Iterable<Schwein> sucheAlle() {
        return mapper.convert(raw.findAll());
    }

    @Override
    public boolean exist(String id) {
        return raw.existsById(id);
    }
}
