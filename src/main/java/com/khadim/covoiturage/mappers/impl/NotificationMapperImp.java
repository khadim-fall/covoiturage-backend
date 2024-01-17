package com.khadim.covoiturage.mappers.impl;

import com.khadim.covoiturage.dao.model.Notification;
import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dto.NotificationDTO;
import com.khadim.covoiturage.mappers.interfaces.INotificationMapper;
import com.khadim.covoiturage.mappers.interfaces.IReservationMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("NotificationMapperImpV1")
public class NotificationMapperImp implements INotificationMapper {
    @Autowired
    @Qualifier("ReservationMapperImpV1")
    private IReservationMapper mapper;
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper userMapper;

    @Override
    public NotificationDTO getNotificationToNotificationDTO(Notification data) {
        if (data == null) return null;
        NotificationDTO dto = new NotificationDTO();
        dto.setId(data.getId());
        dto.setMessage(data.getMessage());
        dto.setUser(userMapper.getUtilisateurToUtilisateurDTO(data.getUser()));
       // Reservation refReservation = data.getReservation();
        //refReservation.setUser(null);
        dto.setReservationDTO(mapper.getReservationToReservationDTO(data.getReservation()));
        dto.setArchive(data.isArchive());
        dto.setDateCreate(data.getDateCreate());
        dto.setDateUpdate(data.getDateUpdate());
        dto.setUserId(data.getUserId());
        return dto;
    }

    @Override
    public Notification getNotificationDTOToNotification(NotificationDTO data) {
        if (data == null) return null;
        Notification entity = new Notification();
        entity.setId(data.getId());
        entity.setMessage(data.getMessage());
        entity.setUser(userMapper.getUtilisateurDTOToUtilisateur(data.getUser()));
        entity.setReservation(mapper.getReservationDTOToReservation(data.getReservationDTO()));
        entity.setArchive(data.isArchive());
        entity.setDateCreate(data.getDateCreate());
        entity.setDateUpdate(data.getDateUpdate());
        entity.setUserId(data.getUserId());
        return entity;
    }
}