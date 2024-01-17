package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.TypeReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TypeReservationRepositoryV1")
public interface TypeReservationRepository extends JpaRepository<TypeReservation, Long> {
    @Query("select typRes from TypeReservation typRes where typRes.supprime = "+false)
    List<TypeReservation> getAll() ;
    @Query("SELECT typRes FROM TypeReservation typRes WHERE typRes.id = :identifier AND typRes.supprime = false")
    TypeReservation getById(@Param("identifier") Long identifier);
}
