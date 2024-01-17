package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Profil;
import com.khadim.covoiturage.dao.repository.ProfilRepository;
import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.mappers.interfaces.IProfilMapper;
import com.khadim.covoiturage.service.interfaces.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("ProfilServiceImpV1")
@Transactional
public class ProfilServiceImp implements IProfilService {
    @Autowired
    @Qualifier("ProfilRepositoryV1")
    private ProfilRepository dao;
    @Autowired
    @Qualifier("ProfilMapperImpV1")
    private IProfilMapper mapper;

    @Override
    public ProfilDTO save(ProfilDTO entity) {
        return mapper.getProfilToProfilDTO(dao.save(mapper.getProfilDTOToProfil(entity)));
    }

    @Override
    public ProfilDTO update(ProfilDTO entity) {
        return mapper.getProfilToProfilDTO(dao.save(mapper.getProfilDTOToProfil(entity)));
    }

    @Override
    public ProfilDTO findById(Long id) {
        return mapper.getProfilToProfilDTO(dao.getById(id));
    }

    @Override
    public List<ProfilDTO> findAll() {
        return dao.getAll().stream().map(profil -> mapper.getProfilToProfilDTO(profil)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Profil profil = dao.getById(id);
            if(profil!=null) {
                profil.setSupprime(true);
                dao.save(profil);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
