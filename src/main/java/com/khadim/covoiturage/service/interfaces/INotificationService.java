package com.khadim.covoiturage.service.interfaces;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.NotificationDTO;

import java.util.List;

public interface INotificationService {
    public NotificationDTO save(NotificationDTO entity);
    public NotificationDTO update(NotificationDTO entity);
    public NotificationDTO findById(Long id);
    public List<NotificationDTO> findAll();
    public boolean delete(Long id);
}
