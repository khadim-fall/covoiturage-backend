package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Trajet;
import com.khadim.covoiturage.dao.repository.TrajetRepository;
import com.khadim.covoiturage.dto.TrajetDTO;
import com.khadim.covoiturage.mappers.interfaces.ITrajetMapper;
import com.khadim.covoiturage.service.interfaces.ITrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("TrajetServiceImpV1")
@Transactional
public class TrajetServiceImp implements ITrajetService {

    @Autowired
    @Qualifier("TrajetRepositoryV1")
    private TrajetRepository dao;
    @Autowired
    @Qualifier("TrajetMapperImpV1")
    private ITrajetMapper mapper;


    @Override
    public TrajetDTO save(TrajetDTO entity) {
        return mapper.getTrajetToTrajetDTO(dao.save(mapper.getTrajetDTOToTrajet(entity)));
    }

    @Override
    public TrajetDTO update(TrajetDTO entity) {
        return mapper.getTrajetToTrajetDTO(dao.save(mapper.getTrajetDTOToTrajet(entity)));
    }

    @Override
    public TrajetDTO findById(Long id) {
        return mapper.getTrajetToTrajetDTO(dao.getById(id));
    }

    @Override
    public List<TrajetDTO> findAll() {
        return dao.getAll().stream().map(Trajet -> mapper.getTrajetToTrajetDTO(Trajet)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Trajet trajet = dao.getById(id);
            if(trajet!=null) {
                trajet.setSupprime(true);
                dao.save(trajet);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
