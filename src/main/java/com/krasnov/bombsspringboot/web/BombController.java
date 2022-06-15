package com.krasnov.bombsspringboot.web;
import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import com.krasnov.bombsspringboot.utils.config.BombConverter;
import com.krasnov.bombsspringboot.utils.config.BombMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.krasnov.bombsspringboot.service.BombService;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
@Tag(name = "Bomb",description = "Bomb API")
public class BombController {
    private final BombService bombService;

    private final BombConverter bombConverter;

    @PostMapping("/bombs")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Bomb Created")
    @Operation(summary = "This is endpoint to add a new bomb", description = "Create request to add a new bomb", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new bomb is successfully created and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already exists")})
    public BombDto createBomb(@RequestBody @Valid BombDto requestForSave) {
       var bomb = bombConverter.getMapperFacade().map(requestForSave, Bomb.class);
       var dto = bombConverter.toDto(bombService.create(bomb));
       return dto;
    }



@PutMapping("/bombs/{id}")
@ResponseStatus(HttpStatus.OK)
@Operation(summary = "This is endpoint to change bomb by ID", description = "Create request to change bomb by ID", tags = {"Bomb"})
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "UPDATED. This bomb is successfully updated and added to database"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
        @ApiResponse(responseCode = "409", description = "Bomb already exists")})
public Bomb putBomb(@PathVariable("id") Integer id, @RequestBody Bomb bomb) {
    return bombService.update(id, bomb);
}

    @GetMapping("/bombs")
    @Operation(summary = "This is endpoint to view all bombs in database", description = "Create request to view all bombs in database", tags = {"Bomb"})
    public Collection<Bomb>getAllBombs() {
        return bombService.view();
    }



    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK) // just in case double check!!!
    @Operation(summary = "This is endpoint to view bomb by ID", description = "Create request to view bomb by ID", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK. Pls see requested bomb by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already exists")})
    public Bomb getBomb(@PathVariable Integer id) {
        Bomb bomb = bombService.viewById(id);
        return bomb;
    }

    @PatchMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "This is endpoint to safe delete bomb by ID", description = "Create request to safe delete bomb by ID", tags = {"Bomb"})
    public void removeBomb(@PathVariable Integer id) { //write message to client "bomb was deleted by ID"
        bombService.delete(id);
    }

    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "This is endpoint to delete all bombs in database", description = "NOW THIS ENDPOINT IS BLOCKED!!!", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bomb by requested ID deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bom request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already deleted")})
    public void removeAllBombs() {
        //bombService.deleteAll();
    }

    @GetMapping(value = "/bombs/name", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view bomb by  name", description = "Create request to view bombs by  name", tags = {"Bomb"})
    public Collection<Bomb> findBombByName(String name) {
        return bombService.findBombByName(name);

    }

    @GetMapping(value = "/bombs/country", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view bombs by country", description = "Create request to view bombs by country", tags = {"Bombs"})
    public Collection<Bomb> findBombByCountry(String country) {
        return bombService.findBombByCountry(country);
    }

    @GetMapping(value = "/bombs/weight", params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view bombs by weight", description = "Create request to view bombs by weight", tags = {"Bombs"})
    public Collection<Bomb> findBombByWeight(int weight) {
        return bombService.findBombByWeight(weight);

    }

    @GetMapping(value = "/bombs/nuclears", params = {"nuclearBombs"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "This is endpoint to view if the bombs is nuclear", description = "Create request to view if the bomb is nuclear", tags = {"Bombs"})
    public Collection<Bomb> findBombByNuclear() {
        return bombService.findBombByNuclear();
    }
}



