package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dao.repository.VehiculeRepository;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.mappers.interfaces.IVehiculeMapper;
import com.khadim.covoiturage.service.interfaces.IVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("VehiculeServiceImpV1")
@Transactional
public class VehiculeServiceImp implements IVehiculeService {

    @Autowired
    @Qualifier("VehiculeRepositoryV1")
    private VehiculeRepository dao;
    @Autowired
    @Qualifier("VehiculeMapperImpV1")
    private IVehiculeMapper mapper;


    @Override
    public VehiculeDTO save(VehiculeDTO entity) {
        return mapper.getVehiculeToVehiculeDTO(dao.save(mapper.getVehiculeDTOToVehicule(entity)));
    }

    @Override
    public VehiculeDTO update(VehiculeDTO entity) {
        return mapper.getVehiculeToVehiculeDTO(dao.save(mapper.getVehiculeDTOToVehicule(entity)));
    }

    @Override
    public VehiculeDTO findById(Long id) {
        return mapper.getVehiculeToVehiculeDTO(dao.getById(id));
    }

    @Override
    public List<VehiculeDTO> findAll() {
        return dao.getAll().stream().map(vehicule -> mapper.getVehiculeToVehiculeDTO(vehicule)).collect(Collectors.toList());
    }

    @Override
    public List<VehiculeDTO> findByUserId(Long id) {
        return dao.getVehiculesById(id).stream().map(
                vehicule -> mapper.getVehiculeToVehiculeDTO(vehicule)
        ).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Vehicule vehicule = dao.getById(id);
            if(vehicule!=null) {
                vehicule.setSupprime(true);
                dao.save(vehicule);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
