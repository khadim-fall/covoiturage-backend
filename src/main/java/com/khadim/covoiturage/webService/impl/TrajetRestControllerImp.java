package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.TrajetDTO;
import com.khadim.covoiturage.service.interfaces.ITrajetService;
import com.khadim.covoiturage.webService.interfaces.ITrajetRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TrajetRestControllerImpV1")
@CrossOrigin("*")
public class TrajetRestControllerImp implements ITrajetRestController {

    @Autowired
    @Qualifier("TrajetServiceImpV1")
    private ITrajetService service;

    @Override
    public TrajetDTO save(TrajetDTO entity) {
        return service.save(entity);
    }

    @Override
    public TrajetDTO update(TrajetDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<TrajetDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public TrajetDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
