package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Avis;
import com.khadim.covoiturage.dao.repository.AvisRepository;
import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.mappers.interfaces.IAvisMapper;
import com.khadim.covoiturage.service.interfaces.IAvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("AvisServiceImpV1")
@Transactional
public class AvisServiceImp implements IAvisService {

    @Autowired
    @Qualifier("AvisRepositoryV1")
    private AvisRepository dao;
    @Autowired
    @Qualifier("AvisMapperImpV1")
    private IAvisMapper mapper;


    @Override
    public AvisDTO save(AvisDTO entity) {
        return mapper.getAvisToAvisDTO(dao.save(mapper.getAvisDTOToAvis(entity)));
    }

    @Override
    public AvisDTO update(AvisDTO entity) {
        return mapper.getAvisToAvisDTO(dao.save(mapper.getAvisDTOToAvis(entity)));
    }

    @Override
    public AvisDTO findById(Long id) {
        return mapper.getAvisToAvisDTO(dao.getById(id));
    }

    @Override
    public List<AvisDTO> findAll() {
        return dao.getAll().stream().map(avis -> mapper.getAvisToAvisDTO(avis)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Avis avis = dao.getById(id);
            if(avis!=null) {
                avis.setSupprime(true);
                dao.save(avis);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
