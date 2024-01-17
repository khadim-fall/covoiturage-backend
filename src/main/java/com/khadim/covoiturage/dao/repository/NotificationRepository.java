package com.khadim.covoiturage.dao.repository;

import com.khadim.covoiturage.dao.model.CategoriePermis;
import com.khadim.covoiturage.dao.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NotificationRepositoryV1")
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("select notif from Notification notif where notif.supprime = "+false)
    List<Notification> getAll() ;
    @Query("SELECT notif FROM Notification notif WHERE notif.id = :identifier AND notif.supprime = false")
    Notification getById(@Param("identifier") Long identifier);
}
