package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.TypeReservationDTO;

import java.util.List;

public interface ITypeReservationService {
    public TypeReservationDTO save(TypeReservationDTO entity);
    public TypeReservationDTO update(TypeReservationDTO entity);
    public TypeReservationDTO findById(Long id);
    public List<TypeReservationDTO> findAll();
    public boolean delete(Long id);
}
