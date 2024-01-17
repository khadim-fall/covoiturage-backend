package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TrajetRepositoryV1")
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    @Query("select trajet from Trajet trajet where trajet.supprime = "+false)
    List<Trajet> getAll() ;
    @Query("SELECT trajet FROM Trajet trajet WHERE trajet.id = :identifier AND trajet.supprime = false")
    Trajet getById(@Param("identifier") Long identifier);
}
