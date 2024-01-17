package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.service.interfaces.IUtilisateurService;
import com.khadim.covoiturage.webService.interfaces.IUtilisateurRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("utilisateurRestControllerImpV1")
@CrossOrigin("*")
public class UtilisateurRestControllerImp implements IUtilisateurRestController {

    @Autowired
    @Qualifier("UtilisateurServiceImpV1")
    private IUtilisateurService service;
    @Override
    public UtilisateurDTO save(UtilisateurDTO entity) {
        return service.save(entity);
    }

    @Override
    public UtilisateurDTO update(UtilisateurDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<UtilisateurDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public UtilisateurDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
