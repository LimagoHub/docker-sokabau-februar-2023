package com.example.schweineservice.adapter.mapper;

import com.example.schweineservice.adapter.dto.SchweinDto;
import com.example.schweineservice.domain.model.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinDtoMapper {

    Schwein convert(SchweinDto dto);
    SchweinDto convert(Schwein schwein);

    Iterable<SchweinDto> convert (Iterable<Schwein> schwein);
 }
