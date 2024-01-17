package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.UserProfil;
import com.khadim.covoiturage.dao.repository.UserProfilRepository;
import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.dto.UserProfilDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUserProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import com.khadim.covoiturage.service.interfaces.IUserProfilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("UserProfilServiceImpV1")
@Slf4j
@Transactional
public class UserProfilServiceImp implements IUserProfilService {
    @Autowired
    @Qualifier("UserProfilRepositoryV1")
    private UserProfilRepository dao;
    @Autowired
    @Qualifier("UserProfilMapperImpV1")
    private IUserProfilMapper mapper;
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper userMapper;
    @Autowired
    @Qualifier("ProfilMapperImpV1")
    private IProfilMapper profilMapper;

    @Override
    public UserProfilDTO save(UserProfilDTO entity) {
        if (entity == null || entity.getProfil() == null || entity.getUser() == null) return null;
        return mapper.getUserProfilToUserProfilDTO(dao.save(mapper.getUserProfilDTOToUserProfil(entity)));
    }

    @Override
    public UserProfilDTO update(UserProfilDTO entity) {
        if (entity == null || entity.getProfil() == null || entity.getUser() == null) return null;
        return mapper.getUserProfilToUserProfilDTO(dao.save(mapper.getUserProfilDTOToUserProfil(entity)));
    }

    @Override
    public UserProfilDTO findById(Long id) {
        return mapper.getUserProfilToUserProfilDTO(dao.getById(id));
    }

    @Override
    public List<UserProfilDTO> findByUser(UtilisateurDTO user) {
        return dao.getUserProfilByUserRef(userMapper.getUtilisateurDTOToUtilisateur(user)).stream().map(
                userProfil -> mapper.getUserProfilToUserProfilDTO(userProfil)
        ).collect(Collectors.toList());
    }

    @Override
    public List<UserProfilDTO> findAll() {
        return dao.getAll().stream().map(userProfil -> mapper.getUserProfilToUserProfilDTO(userProfil)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteByUserAndProfil(UtilisateurDTO user, ProfilDTO profil) {
        try {
            dao.deleteByProfilAndUser(userMapper.getUtilisateurDTOToUtilisateur(user), profilMapper.getProfilDTOToProfil(profil));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            UserProfil userProfil = dao.getById(id);
            if(userProfil!=null) {
                userProfil.setSupprime(true);
                dao.save(userProfil);
                return true;
            }
            return false;
        }catch (Exception e){
        return false;
        }
    }
}
