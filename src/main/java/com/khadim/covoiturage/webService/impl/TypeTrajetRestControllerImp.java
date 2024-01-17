package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.service.interfaces.ITypeTrajetService;
import com.khadim.covoiturage.webService.interfaces.ITypeTrajetRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TypeTrajetRestControllerImpV1")
@CrossOrigin("*")
public class TypeTrajetRestControllerImp implements ITypeTrajetRestController {

    @Autowired
    @Qualifier("TypeTrajetServiceImpV1")
    private ITypeTrajetService service;

    @Override
    public TypeTrajetDTO save(TypeTrajetDTO entity) {
        return service.save(entity);
    }

    @Override
    public TypeTrajetDTO update(TypeTrajetDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<TypeTrajetDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public TypeTrajetDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
