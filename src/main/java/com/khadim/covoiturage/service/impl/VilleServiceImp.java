package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Ville;
import com.khadim.covoiturage.dao.repository.VilleRepository;
import com.khadim.covoiturage.dto.VilleDTO;
import com.khadim.covoiturage.mappers.interfaces.IVilleMapper;
import com.khadim.covoiturage.service.interfaces.IVilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("VilleServiceImpV1")
@Transactional
public class VilleServiceImp implements IVilleService {

    @Autowired
    @Qualifier("VilleRepositoryV1")
    private VilleRepository dao;
    @Autowired
    @Qualifier("VilleMapperImpV1")
    private IVilleMapper mapper;


    @Override
    public VilleDTO save(VilleDTO entity) {
        return mapper.getVilleToVilleDTO(dao.save(mapper.getVilleDTOToVille(entity)));
    }

    @Override
    public VilleDTO update(VilleDTO entity) {
        return mapper.getVilleToVilleDTO(dao.save(mapper.getVilleDTOToVille(entity)));
    }

    @Override
    public VilleDTO findById(Long id) {
        return mapper.getVilleToVilleDTO(dao.getById(id));
    }

    @Override
    public List<VilleDTO> findAll() {
        return dao.getAll().stream().map(ville -> mapper.getVilleToVilleDTO(ville)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {

            Ville ville = dao.getById(id);
            if(ville!=null) {
                ville.setSupprime(true);
                dao.save(ville);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
