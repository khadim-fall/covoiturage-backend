package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;

public interface IReservationMapper {
    public ReservationDTO getReservationToReservationDTO(Reservation data);
    public Reservation getReservationDTOToReservation(ReservationDTO data);
}
