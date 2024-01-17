package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dao.model.Ville;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.dto.VilleDTO;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import com.khadim.covoiturage.mappers.interfaces.IVehiculeMapper;
import com.khadim.covoiturage.mappers.interfaces.IVilleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("VilleMapperImpV1")
public class VilleMapperImp implements IVilleMapper {

    @Override
    public VilleDTO getVilleToVilleDTO(Ville data) {
        if (data == null) return null;
        VilleDTO dto = new VilleDTO();
        dto.setId(data.getId());
        dto.setNom(data.getNom());
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Ville getVilleDTOToVille(VilleDTO data) {
        if (data == null) return null;
        Ville entity = new Ville();
        entity.setId(data.getId());
        entity.setUserId(data.getUserId());
        entity.setNom(data.getNom());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}
