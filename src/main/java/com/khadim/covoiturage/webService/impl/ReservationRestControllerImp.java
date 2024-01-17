package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.VehiculeDTO;
import com.khadim.covoiturage.service.interfaces.IReservationService;
import com.khadim.covoiturage.service.interfaces.IVehiculeService;
import com.khadim.covoiturage.webService.interfaces.IReservationRestController;
import com.khadim.covoiturage.webService.interfaces.IVehiculeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ReservationRestControllerImpV1")
@CrossOrigin("*")
public class ReservationRestControllerImp implements IReservationRestController {

    @Autowired
    @Qualifier("ReservationServiceImpV1")
    private IReservationService service;

    @Override
    public ReservationDTO save(ReservationDTO entity) {
        return service.save(entity);
    }

    @Override
    public ReservationDTO update(ReservationDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<ReservationDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public ReservationDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
