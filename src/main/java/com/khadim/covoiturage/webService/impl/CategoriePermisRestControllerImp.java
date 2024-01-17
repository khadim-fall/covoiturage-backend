package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import com.khadim.covoiturage.dto.CategoriePermisDTO;
import com.khadim.covoiturage.dto.UtilisateurDTO;
import com.khadim.covoiturage.service.interfaces.ICategoriePermisService;
import com.khadim.covoiturage.service.interfaces.IUtilisateurService;
import com.khadim.covoiturage.webService.interfaces.ICategoriePermisRestController;
import com.khadim.covoiturage.webService.interfaces.IUtilisateurRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("categoriePermisRestControllerImpV1")
@CrossOrigin("*")
public class CategoriePermisRestControllerImp implements ICategoriePermisRestController {

    @Autowired
    @Qualifier("CategoriePermisServiceImpV1")
    private ICategoriePermisService service;
    @Override
    public CategoriePermisDTO save(CategoriePermisDTO entity) {
        return service.save(entity);
    }

    @Override
    public CategoriePermisDTO update(CategoriePermisDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<CategoriePermisDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public CategoriePermisDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
