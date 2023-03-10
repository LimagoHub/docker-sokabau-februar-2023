package com.example.schweineservice.adapter.web;


import com.example.schweineservice.adapter.dto.SchweinDto;
import com.example.schweineservice.adapter.mapper.SchweinDtoMapper;
import com.example.schweineservice.application.SchweineCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/schweine")
@AllArgsConstructor
public class SchweinCommandController {

    private SchweinDtoMapper mapper;
    private SchweineCommandHandler handler;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> speichern(@Valid @RequestBody SchweinDto schweinDto,   UriComponentsBuilder builder) {
        handler.handleSpeichern(mapper.convert(schweinDto));
        var uri = builder.path("/v1/schweine/{id}").buildAndExpand(schweinDto.getId());
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable String id,@Valid @RequestBody SchweinDto schweinDto) {
        handler.handleUpdate(mapper.convert(schweinDto));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if(handler.handleRemove(id))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping(value = "/{id}/fuettern")
    public ResponseEntity<Void> fuettern(@PathVariable String id) {
        if(handler.handleFuetter(id))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }


}
