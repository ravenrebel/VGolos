package com.vgolos.VGolos.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<ENTITY, DTO> {

    DTO convertToDTO(final ENTITY entity);

    ENTITY convertToEntity(final DTO dto);


    default List<ENTITY> convertToEntity(final List<DTO> dtos) {
        List<ENTITY> entities = new ArrayList<>();
        if (dtos != null) {
            entities = dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
        }
        return entities;
    }

    default List<DTO> convertToDTO(final List<ENTITY> entities) {
        List<DTO> dtos = new ArrayList<>();
        if (entities != null) {
            dtos = entities.stream().map(this::convertToDTO).collect(Collectors.toList());
        }
        return dtos;
    }
}