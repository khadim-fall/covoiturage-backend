package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.ProfilDTO;

import java.util.List;

public interface IProfilService {
    public ProfilDTO save(ProfilDTO entity);
    public ProfilDTO update(ProfilDTO entity);
    public ProfilDTO findById(Long id);
    public List<ProfilDTO> findAll();
    public boolean delete(Long id);
}
