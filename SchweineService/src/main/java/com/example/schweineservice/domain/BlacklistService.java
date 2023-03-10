package com.example.schweineservice.domain;

import com.example.schweineservice.domain.model.Schwein;

public interface BlacklistService {

    boolean isBlacklisted(Schwein s);
}
