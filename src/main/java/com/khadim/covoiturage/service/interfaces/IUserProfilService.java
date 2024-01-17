package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.dto.UserProfilDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;

import java.util.List;

public interface IUserProfilService {
    public UserProfilDTO save(UserProfilDTO entity);
    public UserProfilDTO update(UserProfilDTO entity);
    public UserProfilDTO findById(Long id);
    public List<UserProfilDTO> findByUser(UtilisateurDTO user);
    public List<UserProfilDTO> findAll();
    public boolean deleteByUserAndProfil(UtilisateurDTO user, ProfilDTO profil);
    public boolean delete(Long id);
}
