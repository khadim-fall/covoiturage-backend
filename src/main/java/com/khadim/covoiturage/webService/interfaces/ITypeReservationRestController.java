package com.khadim.covoiturage.webService.interfaces;

import com.khadim.covoiturage.dto.ReservationDTO;
import com.khadim.covoiturage.dto.TypeReservationDTO;
import com.khadim.covoiturage.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "/typeReservations")
public interface ITypeReservationRestController {
    @PostMapping(path = Constants.APP_ROOT + "/typeReservations/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un type de Reservation", notes = "Cette API permet d'enregistrer un type de Reservation", response = TypeReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeReservation est enregistrée avec succés")
    })
    public TypeReservationDTO save(@RequestBody TypeReservationDTO entity);

    @PutMapping(path = Constants.APP_ROOT + "/typeReservations/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre à jour un type de reservation", notes = "Cette API permet de mettre à jour un type de Reservation", response = TypeReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance Reservation est mise à jours")
    })
    public TypeReservationDTO update(@RequestBody TypeReservationDTO entity);

    @GetMapping(path = Constants.APP_ROOT + "/typeReservations/all")
    @ApiOperation(value = "Lister les type de Reservations", notes = "Cette API permet de lister les types de Reservations existants dans la BD", responseContainer = "List<TypeReservationDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des types de Reservations / Liste vide")
    })
    public List<TypeReservationDTO> selectAll();

    @GetMapping(path = Constants.APP_ROOT + "/typeReservations/findById/{id}")
    @ApiOperation(value = "Charger un type de Reservation par son ID", notes = "Cette API permet de charger un type de Reservation par son ID", response = TypeReservationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeReservation existe dans la BD")
    })
    public TypeReservationDTO getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(path = Constants.APP_ROOT + "/typeReservations/delete/{id}")
    @ApiOperation(value = "Supprimer un TypeReservation", notes = "Cette API permet de supprimer un type de Reservation par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'instance TypeReservation est supprimè / Non supprimer car lié à une autre entité")
    })
    public boolean delete(@PathVariable(name = "id") Long id);
}
