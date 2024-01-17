package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.TrajetDTO;
import com.khadim.covoiturage.dto.TypeTrajetDTO;

import java.util.List;

public interface ITrajetService {
    public TrajetDTO save(TrajetDTO entity);
    public TrajetDTO update(TrajetDTO entity);
    public TrajetDTO findById(Long id);
    public List<TrajetDTO> findAll();
    public boolean delete(Long id);
}
