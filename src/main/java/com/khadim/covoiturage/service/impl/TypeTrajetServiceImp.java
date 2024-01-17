package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.TypeTrajet;
import com.khadim.covoiturage.dao.repository.TypeTrajetRepository;
import com.khadim.covoiturage.dto.TypeTrajetDTO;
import com.khadim.covoiturage.mappers.interfaces.ITypeTrajetMapper;
import com.khadim.covoiturage.service.interfaces.ITypeTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("TypeTrajetServiceImpV1")
@Transactional
public class TypeTrajetServiceImp implements ITypeTrajetService {

    @Autowired
    @Qualifier("TypeTrajetRepositoryV1")
    private TypeTrajetRepository dao;
    @Autowired
    @Qualifier("TypeTrajetMapperImpV1")
    private ITypeTrajetMapper mapper;


    @Override
    public TypeTrajetDTO save(TypeTrajetDTO entity) {
        return mapper.getTypeTrajetToTypeTrajetDTO(dao.save(mapper.getTypeTrajetDTOToTypeTrajet(entity)));
    }

    @Override
    public TypeTrajetDTO update(TypeTrajetDTO entity) {
        return mapper.getTypeTrajetToTypeTrajetDTO(dao.save(mapper.getTypeTrajetDTOToTypeTrajet(entity)));
    }

    @Override
    public TypeTrajetDTO findById(Long id) {
        return mapper.getTypeTrajetToTypeTrajetDTO(dao.getById(id));
    }

    @Override
    public List<TypeTrajetDTO> findAll() {
        return dao.getAll().stream().map(typeTrajet -> mapper.getTypeTrajetToTypeTrajetDTO(typeTrajet)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            TypeTrajet typeTrajet = dao.getById(id);
            if(typeTrajet!=null) {
                typeTrajet.setSupprime(true);
                dao.save(typeTrajet);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
