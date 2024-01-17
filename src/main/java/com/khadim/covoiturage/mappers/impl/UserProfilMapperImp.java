package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.UserProfil;
import com.khadim.covoiturage.dto.UserProfilDTO;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUserProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UserProfilMapperImpV1")
public class UserProfilMapperImp implements IUserProfilMapper {
    @Autowired
    @Qualifier("ProfilMapperImpV1")
    private IProfilMapper profilMapper;
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper userMapper;
    @Override
    public UserProfilDTO getUserProfilToUserProfilDTO(UserProfil data) {
        if (data == null) return null;
        UserProfilDTO dto = new UserProfilDTO();
        dto.setId(data.getId());
        dto.setProfil(profilMapper.getProfilToProfilDTO(data.getProfil()));
        dto.setUser(userMapper.getUtilisateurToUtilisateurDTO(data.getUser()));
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public UserProfil getUserProfilDTOToUserProfil(UserProfilDTO data) {
        if (data == null) return null;
        UserProfil entity = new UserProfil();
        entity.setId(data.getId());
        entity.setProfil(profilMapper.getProfilDTOToProfil(data.getProfil()));
        entity.setUser(userMapper.getUtilisateurDTOToUtilisateur(data.getUser()));
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setUserId(data.getUserId());
        return entity;
    }
}
