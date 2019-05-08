package com.vgolos.VGolos.dto.converter;

import com.vgolos.VGolos.dto.ElectionDTO;
import com.vgolos.VGolos.entity.Election;

public class ElectionConverter implements Converter<Election, ElectionDTO> {

    @Override
    public ElectionDTO convertToDTO(Election election) {
        return null;
    }

    @Override
    public Election convertToEntity(ElectionDTO electionDTO) {
        return null;
    }
}
