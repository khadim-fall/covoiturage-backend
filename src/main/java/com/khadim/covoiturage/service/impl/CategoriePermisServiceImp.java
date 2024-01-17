package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import com.khadim.covoiturage.dao.repository.CategoriePermisRepository;
import com.khadim.covoiturage.dto.CategoriePermisDTO;
import com.khadim.covoiturage.mappers.interfaces.ICategoriePermisMapper;
import com.khadim.covoiturage.service.interfaces.ICategoriePermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("CategoriePermisServiceImpV1")
@Transactional
public class CategoriePermisServiceImp implements ICategoriePermisService {

    @Autowired
    @Qualifier("CategoriePermisRepositoryV1")
    private CategoriePermisRepository dao;
    @Autowired
    @Qualifier("CategoriePermisMapperImpV1")
    private ICategoriePermisMapper mapper;



    @Override
    public CategoriePermisDTO save(CategoriePermisDTO entity) {
        return mapper.getCategoriePermisToCategoriePermisDTO(dao.save(mapper.getCategoriePermisDTOToCategoriePermis(entity)));
    }

    @Override
    public CategoriePermisDTO update(CategoriePermisDTO entity) {
        return mapper.getCategoriePermisToCategoriePermisDTO(dao.save(mapper.getCategoriePermisDTOToCategoriePermis(entity)));
    }

    @Override
    public CategoriePermisDTO findById(Long id) {
        return mapper.getCategoriePermisToCategoriePermisDTO(dao.getById(id));
    }

    @Override
    public List<CategoriePermisDTO> findAll() {
        return dao.getAll().stream().map(categoriePermis -> mapper.getCategoriePermisToCategoriePermisDTO(categoriePermis)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {

        try {
            CategoriePermis categoriePermis =dao.getById(id);
            if(categoriePermis!=null) {
                categoriePermis.setSupprime(true);
                dao.save(categoriePermis);
                return true;
            }

            return false;
        }catch (Exception e){
            return false;
        }
    }
}
