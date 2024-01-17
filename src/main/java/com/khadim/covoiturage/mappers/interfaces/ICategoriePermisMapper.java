package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import com.khadim.covoiturage.dto.CategoriePermisDTO;

public interface ICategoriePermisMapper {
    public CategoriePermisDTO getCategoriePermisToCategoriePermisDTO(CategoriePermis data);
    public CategoriePermis getCategoriePermisDTOToCategoriePermis(CategoriePermisDTO data);
}
