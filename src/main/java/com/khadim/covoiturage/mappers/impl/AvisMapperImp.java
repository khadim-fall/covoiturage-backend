package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Avis;
import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.mappers.interfaces.IAvisMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("AvisMapperImpV1")
public class AvisMapperImp implements IAvisMapper {
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper mapper;

    @Override
    public AvisDTO getAvisToAvisDTO(Avis data) {
        if (data == null) return null;
        AvisDTO dto = new AvisDTO();
        dto.setId(data.getId());
        dto.setCommentaire(data.getCommentaire());
        dto.setUser(mapper.getUtilisateurToUtilisateurDTO(data.getUser()));
        dto.setRdv(data.getRdv());
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Avis getAvisDTOToAvis(AvisDTO data) {
        if (data == null) return null;
        Avis entity = new Avis();
        entity.setId(data.getId());
        entity.setCommentaire(data.getCommentaire());
        entity.setUser(mapper.getUtilisateurDTOToUtilisateur(data.getUser()));
        entity.setRdv(data.getRdv());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setUserId(data.getUserId());
        return entity;
    }
}
