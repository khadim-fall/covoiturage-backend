package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;

import java.util.List;

public interface IAvisService {
    public AvisDTO save(AvisDTO entity);
    public AvisDTO update(AvisDTO entity);
    public AvisDTO findById(Long id);
    public List<AvisDTO> findAll();
    public boolean delete(Long id);
}
