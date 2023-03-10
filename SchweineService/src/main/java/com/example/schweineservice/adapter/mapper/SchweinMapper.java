package com.example.schweineservice.adapter.mapper;

import com.example.schweineservice.adapter.dto.SchweinDto;
import com.example.schweineservice.adapter.repository.entity.SchweinEntity;
import com.example.schweineservice.domain.model.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinMapper {

    Schwein convert(SchweinEntity dto);
    SchweinEntity convert(Schwein schwein);

    Iterable<Schwein> convert (Iterable<SchweinEntity> schweinEntity);
 }
