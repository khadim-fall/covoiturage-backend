package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dao.model.TypeReservation;
import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.TypeReservationDTO;

public interface ITypeReservationMapper {
    public TypeReservationDTO getTypeReservationToTypeReservationDTO(TypeReservation data);
    public TypeReservation getTypeReservationDTOToTypeReservation(TypeReservationDTO data);
}
