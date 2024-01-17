package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.TypeReservation;
import com.khadim.covoiturage.dao.repository.TypeReservationRepository;
import com.khadim.covoiturage.dto.TypeReservationDTO;
import com.khadim.covoiturage.mappers.interfaces.ITypeReservationMapper;
import com.khadim.covoiturage.service.interfaces.ITypeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("TypeReservationServiceImpV1")
@Transactional
public class TypeReservationServiceImp implements ITypeReservationService {

    @Autowired
    @Qualifier("TypeReservationRepositoryV1")
    private TypeReservationRepository dao;
    @Autowired
    @Qualifier("TypeReservationMapperImpV1")
    private ITypeReservationMapper mapper;


    @Override
    public TypeReservationDTO save(TypeReservationDTO entity) {
        return mapper.getTypeReservationToTypeReservationDTO(dao.save(mapper.getTypeReservationDTOToTypeReservation(entity)));
    }

    @Override
    public TypeReservationDTO update(TypeReservationDTO entity) {
        return mapper.getTypeReservationToTypeReservationDTO(dao.save(mapper.getTypeReservationDTOToTypeReservation(entity)));
    }

    @Override
    public TypeReservationDTO findById(Long id) {
        return mapper.getTypeReservationToTypeReservationDTO(dao.getById(id));
    }

    @Override
    public List<TypeReservationDTO> findAll() {
        return dao.getAll().stream().map(typeReservation -> mapper.getTypeReservationToTypeReservationDTO(typeReservation)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            TypeReservation typeReservation = dao.getById(id);
            if(typeReservation!=null) {
                typeReservation.setSupprime(true);
                dao.save(typeReservation);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
