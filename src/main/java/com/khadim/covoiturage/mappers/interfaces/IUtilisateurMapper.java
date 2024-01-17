package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Profil;
import com.khadim.covoiturage.dao.model.Utilisateur;
import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;

public interface IUtilisateurMapper {
    public UtilisateurDTO getUtilisateurToUtilisateurDTO(Utilisateur data);
    public Utilisateur getUtilisateurDTOToUtilisateur(UtilisateurDTO data);
}
