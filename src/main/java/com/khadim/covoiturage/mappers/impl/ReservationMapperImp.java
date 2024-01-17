package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.mappers.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ReservationMapperImpV1")
public class ReservationMapperImp implements IReservationMapper {

    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper utilisateurMapper;
    @Autowired
    @Qualifier("TypeReservationMapperImpV1")
    private ITypeReservationMapper reservationMapper;
    @Autowired
    @Qualifier("TrajetMapperImpV1")
    private ITrajetMapper trajetMapper;
    @Override
    public ReservationDTO getReservationToReservationDTO(Reservation data) {
        if (data == null) return null;
        ReservationDTO dto = new ReservationDTO();
        dto.setId(data.getId());
        dto.setUser(utilisateurMapper.getUtilisateurToUtilisateurDTO(data.getUser()));
        dto.setCommentaire(data.getCommentaire());
        dto.setDesignation(data.getDesignation());
        dto.setEtatReservation(data.getEtatReservation());
        dto.setTrajet(trajetMapper.getTrajetToTrajetDTO(data.getTrajet()));
        dto.setTypeReservation(reservationMapper.getTypeReservationToTypeReservationDTO(data.getTypeReservation()));
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Reservation getReservationDTOToReservation(ReservationDTO data) {
        if (data == null) return null;
        Reservation entity = new Reservation();
        entity.setId(data.getId());
         entity.setUser(utilisateurMapper.getUtilisateurDTOToUtilisateur(data.getUser()));
        entity.setCommentaire(data.getCommentaire());
        entity.setDesignation(data.getDesignation());
        entity.setEtatReservation(data.getEtatReservation());
        entity.setTrajet(trajetMapper.getTrajetDTOToTrajet(data.getTrajet()));
        entity.setTypeReservation(reservationMapper.getTypeReservationDTOToTypeReservation(data.getTypeReservation()));
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setUserId(data.getUserId());
        return entity;
    }
}
