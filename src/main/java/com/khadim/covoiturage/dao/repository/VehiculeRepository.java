package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("VehiculeRepositoryV1")
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    @Query("select v from Vehicule v where v.user.id = :#{#id}")
    public List<Vehicule> getVehiculesById(@Param("id") Long id);

    @Query("select v from Vehicule v where v.supprime = "+false)
    List<Vehicule> getAll() ;
    @Query("SELECT v FROM Vehicule v WHERE v.id = :identifier AND v.supprime = false")
    Vehicule getById(@Param("identifier") Long identifier);
}
