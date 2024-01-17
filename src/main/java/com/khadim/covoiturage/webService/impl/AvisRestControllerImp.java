package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.service.interfaces.IAvisService;
import com.khadim.covoiturage.service.interfaces.IVehiculeService;
import com.khadim.covoiturage.webService.interfaces.IAvisRestController;
import com.khadim.covoiturage.webService.interfaces.IVehiculeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AvisRestControllerImpV1")
@CrossOrigin("*")
public class AvisRestControllerImp implements IAvisRestController {

    @Autowired
    @Qualifier("AvisServiceImpV1")
    private IAvisService service;

    @Override
    public AvisDTO save(AvisDTO entity) {
        return service.save(entity);
    }

    @Override
    public AvisDTO update(AvisDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<AvisDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public AvisDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
