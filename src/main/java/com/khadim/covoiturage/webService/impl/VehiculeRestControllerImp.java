package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.service.interfaces.IVehiculeService;
import com.khadim.covoiturage.webService.interfaces.IVehiculeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("VehiculeRestControllerImpV1")
@CrossOrigin("*")
public class VehiculeRestControllerImp implements IVehiculeRestController {

    @Autowired
    @Qualifier("VehiculeServiceImpV1")
    private IVehiculeService service;

    @Override
    public VehiculeDTO save(VehiculeDTO entity) {
        return service.save(entity);
    }

    @Override
    public VehiculeDTO update(VehiculeDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<VehiculeDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public List<VehiculeDTO> findByUserId(Long id) {
        return service.findByUserId(id);
    }

    @Override
    public VehiculeDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
