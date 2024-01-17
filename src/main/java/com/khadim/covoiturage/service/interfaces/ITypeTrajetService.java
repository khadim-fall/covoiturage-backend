package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.TypeTrajetDTO;

import java.util.List;

public interface ITypeTrajetService {
    public TypeTrajetDTO save(TypeTrajetDTO entity);
    public TypeTrajetDTO update(TypeTrajetDTO entity);
    public TypeTrajetDTO findById(Long id);
    public List<TypeTrajetDTO> findAll();
    public boolean delete(Long id);
}
