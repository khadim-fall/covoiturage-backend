package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("VilleRepositoryV1")
public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Query("select vil from Ville vil where vil.supprime = "+false)
    List<Ville> getAll() ;
    @Query("SELECT v FROM Ville v WHERE v.id = :identifier AND v.supprime = false")
    Ville getById(@Param("identifier") Long identifier);
}
