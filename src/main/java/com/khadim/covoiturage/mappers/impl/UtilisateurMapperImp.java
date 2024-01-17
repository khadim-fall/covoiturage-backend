package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Utilisateur;
import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.mappers.interfaces.ICategoriePermisMapper;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IReservationMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UtilisateurMapperImpV1")
public class UtilisateurMapperImp implements IUtilisateurMapper {
    @Autowired
    @Qualifier("ProfilMapperImpV1")
    private IProfilMapper mapper;
    @Autowired
    @Qualifier("CategoriePermisMapperImpV1")
    private ICategoriePermisMapper categoriePermisMapper;
    @Override
    public UtilisateurDTO getUtilisateurToUtilisateurDTO(Utilisateur data) {
        if (data == null) return null;
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(data.getId());
        dto.setNom(data.getNom());
        dto.setPrenom(data.getPrenom());
        dto.setEmail(data.getEmail());
        dto.setLogin(data.getLogin());
        dto.setPassword(data.getPassword());
        dto.setTelephone(data.getTelephone());
        dto.setAdresse(data.getAdresse());
        dto.setCni(data.getCni());
        dto.setDateNaissance(data.getDateNaissance());
        dto.setPermis(data.isPermis());
        dto.setCategoriePermis(categoriePermisMapper.getCategoriePermisToCategoriePermisDTO(data.getCategoriePermis()));
        if (data.getProfils()!=null)
            data.getProfils().forEach(profil -> {
                dto.getProfils().add(mapper.getProfilToProfilDTO(profil));
            });
        dto.setReservations(data.getReservations());
        dto.setVehicules(data.getVehicules());
        dto.setArchive(data.isArchive());
        dto.setUserId(data.getUserId());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        return dto;
    }

    @Override
    public Utilisateur getUtilisateurDTOToUtilisateur(UtilisateurDTO data) {
        if (data == null) return null;
        Utilisateur entity = new Utilisateur();
        entity.setId(data.getId());
        entity.setNom(data.getNom());
        entity.setPrenom(data.getPrenom());
        entity.setEmail(data.getEmail());
        entity.setLogin(data.getLogin());
        entity.setPassword(data.getPassword());
        entity.setTelephone(data.getTelephone());
        entity.setAdresse(data.getAdresse());
        entity.setCni(data.getCni());
        entity.setDateNaissance(data.getDateNaissance());
        entity.setPermis(data.isPermis());
        entity.setCategoriePermis(categoriePermisMapper.getCategoriePermisDTOToCategoriePermis(data.getCategoriePermis()));
        if (data.getProfils()!=null)
            data.getProfils().forEach(profil -> {
                entity.getProfils().add(mapper.getProfilDTOToProfil(profil));
            });
        //entity.setReservations(data.getReservations());
        //entity.setVehicules(data.getVehicules());
        entity.setArchive(data.isArchive());
        entity.setUserId(data.getUserId());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}