package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.dto.VilleDTO;
import com.khadim.covoiturage.service.interfaces.IVehiculeService;
import com.khadim.covoiturage.service.interfaces.IVilleService;
import com.khadim.covoiturage.webService.interfaces.IVehiculeRestController;
import com.khadim.covoiturage.webService.interfaces.IVilleRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("VilleRestControllerImpV1")
@CrossOrigin("*")
public class VilleRestControllerImp implements IVilleRestController {

    @Autowired
    @Qualifier("VilleServiceImpV1")
    private IVilleService service;

    @Override
    public VilleDTO save(VilleDTO entity) {
        return service.save(entity);
    }

    @Override
    public VilleDTO update(VilleDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<VilleDTO> selectAll() {
        return service.findAll();
    }


    @Override
    public VilleDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
