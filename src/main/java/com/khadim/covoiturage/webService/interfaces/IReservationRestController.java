package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/reservations")
public interface IReservationRestController {
    @PostMapping(path = Constants.APP_ROOT + "/reservations/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Reservation", notes = "Cette API permet d'enregistrer un Reservation", response = ReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Reservation est enregistrée avec succés")
    })
    public ReservationDTO save(@RequestBody ReservationDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/reservations/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour une Reservation", notes = "Cette API permet de mettre à jour une Reservation", response = ReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Reservation est mise à jours")
    })
    public ReservationDTO update(@RequestBody ReservationDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/reservations/all")
    @ApiOperation(value = "Lister les reservations", notes = "Cette API permet de lister les reservations existants dans la BD", responseContainer = "List<ReservationDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des reservations / Liste vide")
    })
    public List<ReservationDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/reservations/findById/{id}")
    @ApiOperation(value = "Charger une Reservation par son ID", notes = "Cette API permet de charger une Reservation par son ID", response = ReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Reservation existe dans la BD")
    })
    public ReservationDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/reservations/delete/{id}")
    @ApiOperation(value = "Supprimer une Reservation", notes = "Cette API permet de supprimer une Reservation par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Reservation est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
