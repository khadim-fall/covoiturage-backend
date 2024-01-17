package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.UtilisateurDTO;

import java.util.List;

public interface IUtilisateurService {
    public UtilisateurDTO save(UtilisateurDTO entity);
    public UtilisateurDTO update(UtilisateurDTO entity);
    public UtilisateurDTO findById(Long id);
    public List<UtilisateurDTO> findAll();
    public boolean delete(Long id);
}
