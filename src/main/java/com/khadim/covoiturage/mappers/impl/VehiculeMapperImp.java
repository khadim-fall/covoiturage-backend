package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import com.khadim.covoiturage.mappers.interfaces.IVehiculeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("VehiculeMapperImpV1")
public class VehiculeMapperImp implements IVehiculeMapper {
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper userMapper;
    @Override
    public VehiculeDTO getVehiculeToVehiculeDTO(Vehicule data) {
        if (data == null) return null;
        VehiculeDTO dto = new VehiculeDTO();
        dto.setId(data.getId());
        dto.setMarque(data.getMarque());
        dto.setImmatriculation(data.getImmatriculation());
        dto.setNombrePlace(data.getNombrePlace());
        dto.setUser(userMapper.getUtilisateurToUtilisateurDTO(data.getUser()));
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Vehicule getVehiculeDTOToVehicule(VehiculeDTO data) {
        if (data == null) return null;
        Vehicule entity = new Vehicule();
        entity.setMarque(data.getMarque());
        entity.setImmatriculation(data.getImmatriculation());
        entity.setNombrePlace(data.getNombrePlace());
        entity.setUser(userMapper.getUtilisateurDTOToUtilisateur(data.getUser()));
        entity.setUserId(data.getUserId());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}
