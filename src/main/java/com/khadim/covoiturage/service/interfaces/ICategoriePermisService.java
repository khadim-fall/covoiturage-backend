package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.CategoriePermisDTO;

import java.util.List;

public interface ICategoriePermisService {
    public CategoriePermisDTO save(CategoriePermisDTO entity);
    public CategoriePermisDTO update(CategoriePermisDTO entity);
    public CategoriePermisDTO findById(Long id);
    public List<CategoriePermisDTO> findAll();
    public boolean delete(Long id);
}
