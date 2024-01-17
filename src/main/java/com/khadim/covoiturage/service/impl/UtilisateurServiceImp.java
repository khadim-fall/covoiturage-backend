package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.UserProfil;
import com.khadim.covoiturage.dao.model.Utilisateur;
import com.khadim.covoiturage.dao.repository.UtilisateurRepository;
import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUserProfilMapper;
import com.khadim.covoiturage.mappers.interfaces.IUtilisateurMapper;
import com.khadim.covoiturage.service.interfaces.IUserProfilService;
import com.khadim.covoiturage.service.interfaces.IUtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service("UtilisateurServiceImpV1")
@Slf4j
@Transactional
public class UtilisateurServiceImp implements IUtilisateurService {
    @Autowired
    @Qualifier("UtilisateurRepositoryV1")
    private UtilisateurRepository dao;
    @Autowired
    @Qualifier("UtilisateurMapperImpV1")
    private IUtilisateurMapper mapper;
    @Autowired
    @Qualifier("ProfilMapperImpV1")
    private IProfilMapper profilMapper;
    @Autowired
    @Qualifier("UserProfilMapperImpV1")
    private IUserProfilMapper userProfilMapper;
    @Autowired
    @Qualifier("UserProfilServiceImpV1")
    private IUserProfilService userProfilService;

    @Override
    public UtilisateurDTO save(UtilisateurDTO entity) {
        if (entity.getAddProfil()!=null){
            entity.setDateCreate(Instant.now());
            entity.setDateUpdate(Instant.now());
            ProfilDTO dto = entity.getAddProfil();
            UserProfil userProfil = new UserProfil();
            userProfil.setProfil(profilMapper.getProfilDTOToProfil(dto));
            userProfil.setUser(mapper.getUtilisateurDTOToUtilisateur(mapper.getUtilisateurToUtilisateurDTO(dao.save(mapper.getUtilisateurDTOToUtilisateur(entity)))));
            userProfil.setUserId(entity.getUserId());
            userProfil.setDateCreate(Instant.now());
            userProfil.setDateUpdate(Instant.now());
            userProfilService.save(userProfilMapper.getUserProfilToUserProfilDTO(userProfil));
        }
        entity = mapper.getUtilisateurToUtilisateurDTO(dao.save(mapper.getUtilisateurDTOToUtilisateur(entity)));
        entity.setProfils(userProfilService.findByUser(entity).stream().map(
                userProfilDTO -> userProfilDTO.getProfil()
        ).collect(Collectors.toList()));
        return entity;
    }

    @Override
    public UtilisateurDTO update(UtilisateurDTO entity) {
        if (entity.getAddProfil()!=null){
            entity.setDateUpdate(Instant.now());
            ProfilDTO dto = entity.getAddProfil();
            UserProfil userProfil = new UserProfil();
            userProfil.setProfil(profilMapper.getProfilDTOToProfil(dto));
            userProfil.setUser(mapper.getUtilisateurDTOToUtilisateur(mapper.getUtilisateurToUtilisateurDTO(dao.save(mapper.getUtilisateurDTOToUtilisateur(entity)))));
            userProfil.setUserId(entity.getUserId());
            userProfil.setDateCreate(Instant.now());
            userProfil.setDateUpdate(Instant.now());
            userProfilService.save(userProfilMapper.getUserProfilToUserProfilDTO(userProfil));
        }else if (entity.getAbstractProfil()!=null){
            ProfilDTO profilDTO = entity.getAbstractProfil();
            entity.setDateUpdate(Instant.now());
            entity = mapper.getUtilisateurToUtilisateurDTO(dao.save(mapper.getUtilisateurDTOToUtilisateur(entity)));
            userProfilService.findByUser(entity).forEach(userProfilDTO -> {
                ProfilDTO profilDTO1 = userProfilDTO.getProfil();
                UtilisateurDTO userDTO = userProfilDTO.getUser();
                if(profilDTO1.getId() == profilDTO.getId())
                    userProfilService.deleteByUserAndProfil(userDTO, profilDTO1);
            });
        }
        entity = mapper.getUtilisateurToUtilisateurDTO(dao.save(mapper.getUtilisateurDTOToUtilisateur(entity)));
        entity.setProfils(userProfilService.findByUser(entity).stream().map(
                userProfilDTO -> userProfilDTO.getProfil()
        ).collect(Collectors.toList()));
        return entity;
    }

    @Override
    public UtilisateurDTO findById(Long id) {
       UtilisateurDTO entity = mapper.getUtilisateurToUtilisateurDTO(dao.getById(id));
       entity.setProfils(userProfilService.findByUser(entity).stream().map(
               userProfilDTO -> userProfilDTO.getProfil()
       ).collect(Collectors.toList()));
       return entity;
    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return dao.getAll().stream().map(utilisateur -> {
            UtilisateurDTO entity = mapper.getUtilisateurToUtilisateurDTO(utilisateur);
            entity.setProfils(userProfilService.findByUser(entity).stream().map(
                    userProfilDTO -> userProfilDTO.getProfil()
            ).collect(Collectors.toList()));
            return entity;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Utilisateur utilisateur = dao.getById(id);
            if(utilisateur!=null) {
                utilisateur.setSupprime(true);
                dao.save(utilisateur);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}