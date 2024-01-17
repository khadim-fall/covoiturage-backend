package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Vehicule;
import com.khadim.covoiturage.dto.VehiculeDTO;

public interface IVehiculeMapper {
    public VehiculeDTO getVehiculeToVehiculeDTO(Vehicule data);
    public Vehicule getVehiculeDTOToVehicule(VehiculeDTO data);
}
