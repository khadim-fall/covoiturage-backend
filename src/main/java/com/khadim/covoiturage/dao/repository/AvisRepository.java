package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AvisRepositoryV1")
public interface AvisRepository extends JpaRepository<Avis, Long> {
    @Query("select avi from Avis avi where avi.supprime = "+false)
    List<Avis> getAll() ;
    @Query("SELECT avi FROM Avis avi WHERE avi.id = :identifier AND avi.supprime = false")
    Avis getById(@Param("identifier") Long identifier);
}
