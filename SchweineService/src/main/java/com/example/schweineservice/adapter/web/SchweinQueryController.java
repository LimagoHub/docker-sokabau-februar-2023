package com.example.schweineservice.adapter.web;


import com.example.schweineservice.adapter.dto.SchweinDto;
import com.example.schweineservice.adapter.mapper.SchweinDtoMapper;
import com.example.schweineservice.domain.SchweineService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/schweine")
@AllArgsConstructor
public class SchweinQueryController {

    private final SchweineService service;
    private final SchweinDtoMapper mapper;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchweinDto> findById(@PathVariable  String id) {
        return ResponseEntity.of(service.sucheNachId(id).map(mapper::convert));
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SchweinDto>> findall(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "10")int gewicht
    ) {
        return ResponseEntity.ok(mapper.convert(service.sucheAlle()));
    }
}
