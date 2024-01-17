package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.dto.VilleDTO;

import java.util.List;

public interface IVilleService {
    public VilleDTO save(VilleDTO entity);
    public VilleDTO update(VilleDTO entity);
    public VilleDTO findById(Long id);
    public List<VilleDTO> findAll();
    public boolean delete(Long id);
}
