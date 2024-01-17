package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    public VehiculeDTO save(VehiculeDTO entity);
    public VehiculeDTO update(VehiculeDTO entity);
    public VehiculeDTO findById(Long id);
    public List<VehiculeDTO> findAll();
    public List<VehiculeDTO> findByUserId(Long id);
    public boolean delete(Long id);
}
