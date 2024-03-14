package com.zamani.delivery.repository.provider.rest;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface IProviderRestRepository<T, ID> {
    JsonNode findAll() throws IOException;

    JsonNode saveAndFlush(T entity) throws IOException;

}
