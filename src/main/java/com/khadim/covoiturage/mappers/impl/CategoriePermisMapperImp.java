package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import com.khadim.covoiturage.dto.CategoriePermisDTO;
import com.khadim.covoiturage.mappers.interfaces.ICategoriePermisMapper;
import org.springframework.stereotype.Component;

@Component("CategoriePermisMapperImpV1")
public class CategoriePermisMapperImp implements ICategoriePermisMapper {

    @Override
    public CategoriePermisDTO getCategoriePermisToCategoriePermisDTO(CategoriePermis data) {
        if (data == null) return null;
        CategoriePermisDTO dto = new CategoriePermisDTO();
        dto.setId(data.getId());
        dto.setUserId(data.getUserId());
        dto.setDesignation(data.getDesignation());
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        return dto;
    }

    @Override
    public CategoriePermis getCategoriePermisDTOToCategoriePermis(CategoriePermisDTO data) {
        if (data == null) return null;
        CategoriePermis entity = new CategoriePermis();
        entity.setId(data.getId());
        entity.setUserId(data.getUserId());
        entity.setDesignation(data.getDesignation());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}
