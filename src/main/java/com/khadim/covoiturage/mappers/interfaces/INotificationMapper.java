package com.khadim.covoiturage.mappers.interfaces;

import com.khadim.covoiturage.dao.model.Avis;
import com.khadim.covoiturage.dao.model.Notification;
import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.NotificationDTO;

public interface INotificationMapper {
    public NotificationDTO getNotificationToNotificationDTO(Notification data);
    public Notification getNotificationDTOToNotification(NotificationDTO data);
}
