package com.example.schweineservice.application;

import com.example.schweineservice.domain.SchweineService;
import com.example.schweineservice.domain.model.Schwein;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class SchweineCommandHandler {


    private final SchweineService service;
    public void handleSpeichern(Schwein schwein) {
        try {
            service.speichern(schwein);
            // Kafka Event feuern
        } catch (Exception e) {
            // Kafka misserfolg
            throw e;
        }
    }
    public void handleUpdate(Schwein schwein) {
        try {
            service.aendern(schwein);
            // Kafka Event feuern
        } catch (Exception e) {
            // Kafka misserfolg
            throw e;
        }
    }
    public boolean handleRemove(String id) {
        try {
            return service.loeschen(id);
            // Kafka Event feuern
        } catch (Exception e) {
            // Kafka misserfolg
            throw e;
        }
    }
    public boolean handleFuetter(String id) {
        try {
            return service.fuettern(id);
            // Kafka Event feuern
        } catch (Exception e) {
            // Kafka misserfolg
            throw e;
        }
    }

}
