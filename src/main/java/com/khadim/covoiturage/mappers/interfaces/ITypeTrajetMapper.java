package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.TypeTrajet;
import com.khadim.covoiturage.dto.TypeTrajetDTO;

public interface ITypeTrajetMapper {
    public TypeTrajetDTO getTypeTrajetToTypeTrajetDTO(TypeTrajet data);
    public TypeTrajet getTypeTrajetDTOToTypeTrajet(TypeTrajetDTO data);
}
