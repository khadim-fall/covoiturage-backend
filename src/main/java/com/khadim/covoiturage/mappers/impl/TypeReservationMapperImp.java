package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.TypeReservation;
import com.khadim.covoiturage.dto.TypeReservationDTO;
import com.khadim.covoiturage.mappers.interfaces.ITypeReservationMapper;
import org.springframework.stereotype.Component;

@Component("TypeReservationMapperImpV1")
public class TypeReservationMapperImp implements ITypeReservationMapper {

    @Override
    public TypeReservationDTO getTypeReservationToTypeReservationDTO(TypeReservation data) {
        if (data == null) return null;
        TypeReservationDTO dto = new TypeReservationDTO();
        dto.setId(data.getId());
        dto.setLibelle(data.getLibelle());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        dto.setArchive(data.isArchive());
        return dto;
    }

    @Override
    public TypeReservation getTypeReservationDTOToTypeReservation(TypeReservationDTO data) {
        if (data == null) return null;
        TypeReservation entity = new TypeReservation();
        entity.setId(data.getId());
        entity.setLibelle(data.getLibelle());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setArchive(data.isArchive());
        return entity;
    }
}
