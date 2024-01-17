package com.khadim.covoiturage.webService.impl;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.NotificationDTO;
import com.khadim.covoiturage.service.interfaces.IAvisService;
import com.khadim.covoiturage.service.interfaces.INotificationService;
import com.khadim.covoiturage.webService.interfaces.IAvisRestController;
import com.khadim.covoiturage.webService.interfaces.INotificationRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("NotificationRestControllerImpV1")
@CrossOrigin("*")
public class NotificationRestControllerImp implements INotificationRestController {

    @Autowired
    @Qualifier("NotificationServiceImpV1")
    private INotificationService service;

    @Override
    public NotificationDTO save(NotificationDTO entity) {
        return service.save(entity);
    }

    @Override
    public NotificationDTO update(NotificationDTO entity) {
        return service.update(entity);
    }

    @Override
    public List<NotificationDTO> selectAll() {
        return service.findAll();
    }

    @Override
    public NotificationDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
