package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Trajet;
import com.khadim.covoiturage.dao.model.TypeTrajet;
import com.khadim.covoiturage.dao.model.Ville;
import com.khadim.covoiturage.dto.TrajetDTO;
import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.dto.VilleDTO;
import com.khadim.covoiturage.mappers.interfaces.ITrajetMapper;
import com.khadim.covoiturage.mappers.interfaces.ITypeTrajetMapper;
import com.khadim.covoiturage.mappers.interfaces.IVilleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("TrajetMapperImpV1")
public class TrajetMapperImp implements ITrajetMapper {

    @Autowired
    @Qualifier("TypeTrajetMapperImpV1")
    private ITypeTrajetMapper typeTrajetMapper;
    @Autowired
    @Qualifier("VilleMapperImpV1")
    private IVilleMapper villeMapper;
    @Override
    public TrajetDTO getTrajetToTrajetDTO(Trajet data) {
        if (data == null) return null;
        TrajetDTO dto = new TrajetDTO();
        //BeanUtils.copyProperties(data,dto);
        dto.setId(data.getId());
        dto.setDuree(data.getDuree());
        dto.setType(typeTrajetMapper.getTypeTrajetToTypeTrajetDTO(data.getType()));
        dto.setDepart(villeMapper.getVilleToVilleDTO(data.getDepart()));
        dto.setArrivee(villeMapper.getVilleToVilleDTO(data.getArrivee()));
        dto.setDistance(data.getDistance());
        dto.setDateDepart(data.getDateDepart());
        dto.setPrix(data.getPrix());
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Trajet getTrajetDTOToTrajet(TrajetDTO data) {
        if (data == null) return null;
        Trajet entity = new Trajet();
        entity.setId(data.getId());
        entity.setDuree(data.getDuree());
        entity.setType(typeTrajetMapper.getTypeTrajetDTOToTypeTrajet(data.getType()));
        entity.setDepart(villeMapper.getVilleDTOToVille(data.getDepart()));
        entity.setArrivee(villeMapper.getVilleDTOToVille(data.getArrivee()));
        entity.setDistance(data.getDistance());
        entity.setDateDepart(data.getDateDepart());
        entity.setPrix(data.getPrix());
        entity.setUserId(data.getUserId());
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        return entity;
    }
}
