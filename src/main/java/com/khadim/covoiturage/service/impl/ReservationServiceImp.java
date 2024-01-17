package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Reservation;
import com.khadim.covoiturage.dao.repository.ReservationRepository;
import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.mappers.interfaces.IReservationMapper;
import com.khadim.covoiturage.service.interfaces.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("ReservationServiceImpV1")
@Transactional
public class ReservationServiceImp implements IReservationService {

    @Autowired
    @Qualifier("ReservationRepositoryV1")
    private ReservationRepository dao;
    @Autowired
    @Qualifier("ReservationMapperImpV1")
    private IReservationMapper mapper;


    @Override
    public ReservationDTO save(ReservationDTO entity) {
        return mapper.getReservationToReservationDTO(dao.save(mapper.getReservationDTOToReservation(entity)));
    }

    @Override
    public ReservationDTO update(ReservationDTO entity) {
        return mapper.getReservationToReservationDTO(dao.save(mapper.getReservationDTOToReservation(entity)));
    }

    @Override
    public ReservationDTO findById(Long id) {
        return mapper.getReservationToReservationDTO(dao.getById(id));
    }

    @Override
    public List<ReservationDTO> findAll() {
        return dao.getAll().stream().map(reservation -> mapper.getReservationToReservationDTO(reservation)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Reservation reservation = dao.getById(id);
            if(reservation!=null) {
                reservation.setSupprime(true);
                dao.save(reservation);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
