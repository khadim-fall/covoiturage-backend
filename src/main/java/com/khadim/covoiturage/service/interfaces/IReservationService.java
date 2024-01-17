package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;

import java.util.List;

public interface IReservationService {
    public ReservationDTO save(ReservationDTO entity);
    public ReservationDTO update(ReservationDTO entity);
    public ReservationDTO findById(Long id);
    public List<ReservationDTO> findAll();
    public boolean delete(Long id);
}
