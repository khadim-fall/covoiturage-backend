package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ReservationRepositoryV1")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select reserv from Reservation reserv where reserv.supprime = "+false)
    List<Reservation> getAll() ;
    @Query("SELECT reserv FROM Reservation reserv WHERE reserv.id = :identifier AND reserv.supprime = false")
    Reservation getById(@Param("identifier") Long identifier);
}
