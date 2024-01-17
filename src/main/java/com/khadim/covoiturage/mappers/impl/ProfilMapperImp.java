package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Profil;
import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import org.springframework.stereotype.Component;

@Component("ProfilMapperImpV1")
public class ProfilMapperImp implements IProfilMapper {
    @Override
    public ProfilDTO getProfilToProfilDTO(Profil data) {
        if (data == null) return null;
        ProfilDTO dto = new ProfilDTO();
        dto.setId(data.getId());
        dto.setDesignation(data.getDesignation());
        dto.setUserId(data.getUserId());
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        return dto;
    }

    @Override
    public Profil getProfilDTOToProfil(ProfilDTO data) {
        if (data == null) return null;
        Profil entity = new Profil();
        entity.setId(data.getId());
        entity.setUserId(data.getUserId());
        entity.setDesignation(data.getDesignation());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}
