package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.AvisDTO;
import com.khadim.covoiturage.dto.NotificationDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/notifications")
public interface INotificationRestController {
    @PostMapping(path = Constants.APP_ROOT + "/notifications/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Notification", notes = "Cette API permet d'enregistrer une Notification", response = NotificationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Notification est enregistrée avec succés")
    })
    public NotificationDTO save(@RequestBody NotificationDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/notifications/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un Notification", notes = "Cette API permet de mettre à jour une Notification", response = NotificationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Notification est mise à jours")
    })
    public NotificationDTO update(@RequestBody NotificationDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/notifications/all")
    @ApiOperation(value = "Lister les Notifications", notes = "Cette API permet de lister les Notifications existants dans la BD", responseContainer = "List<NotificationDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des Notifications / Liste vide")
    })
    public List<NotificationDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/notifications/findById/{id}")
    @ApiOperation(value = "Charger un Notification par son ID", notes = "Cette API permet de charger une Notification par son ID", response = NotificationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Notification existe dans la BD")
    })
    public NotificationDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/notifications/delete/{id}")
    @ApiOperation(value = "Supprimer un Notification", notes = "Cette API permet de supprimer une Notification par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Notification est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
