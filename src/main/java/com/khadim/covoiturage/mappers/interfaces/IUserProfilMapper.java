package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.UserProfil;
import com.khadim.covoiturage.dto.UserProfilDTO;

public interface IUserProfilMapper {
    public UserProfilDTO getUserProfilToUserProfilDTO(UserProfil data);
    public UserProfil getUserProfilDTOToUserProfil(UserProfilDTO data);
}
