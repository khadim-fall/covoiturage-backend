package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.TypeTrajet;
import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.mappers.interfaces.ITypeTrajetMapper;
import org.springframework.stereotype.Component;

@Component("TypeTrajetMapperImpV1")
public class TypeTrajetMapperImp implements ITypeTrajetMapper {

    @Override
    public TypeTrajetDTO getTypeTrajetToTypeTrajetDTO(TypeTrajet data) {
        if (data == null) return null;
        TypeTrajetDTO dto = new TypeTrajetDTO();
        dto.setId(data.getId());
        dto.setDesignation(data.getDesignation());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        dto.setArchive(data.isArchive());
        return dto;
    }

    @Override
    public TypeTrajet getTypeTrajetDTOToTypeTrajet(TypeTrajetDTO data) {
        if (data == null) return null;
        TypeTrajet entity = new TypeTrajet();
        entity.setId(data.getId());
        entity.setDesignation(data.getDesignation());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setArchive(data.isArchive());
        return entity;
    }
}
