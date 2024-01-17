package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.ProfilDTO;
import com.khadim.covoiturage.service.interfaces.IProfilService;
import com.khadim.covoiturage.webService.interfaces.IProfilRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("profilRestControllerImpV1")
@CrossOrigin("*")
public class ProfilRestControllerImp implements IProfilRestController {
    @Autowired
    @Qualifier("ProfilServiceImpV1")
    private IProfilService service;

    @Override
    public ProfilDTO save(ProfilDTO entity) {
        return service.save(entity);
    }

    @Override
    public ProfilDTO update(ProfilDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<ProfilDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public ProfilDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
