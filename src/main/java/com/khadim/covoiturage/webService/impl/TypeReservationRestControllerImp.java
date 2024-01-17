package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.TypeReservationDTO;
import com.khadim.covoiturage.service.interfaces.ITypeReservationService;
import com.khadim.covoiturage.webService.interfaces.ITypeReservationRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TypeReservationRestControllerImpV1")
@CrossOrigin("*")
public class TypeReservationRestControllerImp implements ITypeReservationRestController {

    @Autowired
    @Qualifier("TypeReservationServiceImpV1")
    private ITypeReservationService service;

    @Override
    public TypeReservationDTO save(TypeReservationDTO entity) {
        return service.save(entity);
    }

    @Override
    public TypeReservationDTO update(TypeReservationDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<TypeReservationDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public TypeReservationDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
