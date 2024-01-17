package com.khadim.covoiturage.service.impl;

import com.khadim.covoiturage.dao.model.Notification;
import com.khadim.covoiturage.dao.repository.NotificationRepository;
import com.khadim.covoiturage.dto.NotificationDTO;
import com.khadim.covoiturage.mappers.interfaces.INotificationMapper;
import com.khadim.covoiturage.service.interfaces.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("NotificationServiceImpV1")
@Transactional
public class NotificationServiceImp implements INotificationService {

    @Autowired
    @Qualifier("NotificationRepositoryV1")
    private NotificationRepository dao;
    @Autowired
    @Qualifier("NotificationMapperImpV1")
    private INotificationMapper mapper;


    @Override
    public NotificationDTO save(NotificationDTO entity) {
        return mapper.getNotificationToNotificationDTO(dao.save(mapper.getNotificationDTOToNotification(entity)));
    }

    @Override
    public NotificationDTO update(NotificationDTO entity) {
        return mapper.getNotificationToNotificationDTO(dao.save(mapper.getNotificationDTOToNotification(entity)));
    }

    @Override
    public NotificationDTO findById(Long id) {
        return mapper.getNotificationToNotificationDTO(dao.getById(id));
    }

    @Override
    public List<NotificationDTO> findAll() {
        return dao.getAll().stream().map(notification -> mapper.getNotificationToNotificationDTO(notification)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            Notification notification = dao.getById(id);
            if(notification!=null) {
                notification.setSupprime(true);
                dao.save(notification);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
