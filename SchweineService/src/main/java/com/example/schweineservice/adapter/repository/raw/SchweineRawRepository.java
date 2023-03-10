package com.example.schweineservice.adapter.repository.raw;

import com.example.schweineservice.adapter.repository.entity.SchweinEntity;
import org.springframework.data.repository.CrudRepository;

public interface SchweineRawRepository extends CrudRepository<SchweinEntity, String> {


     Iterable<SchweinEntity> findByName(String name);
}
