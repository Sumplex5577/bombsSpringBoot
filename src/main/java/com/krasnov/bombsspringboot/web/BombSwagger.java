package com.krasnov.bombsspringboot.web;


import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@Tag(name = "Bomb", description = "Bomb API" )
public interface BombSwagger {

    @Operation(summary = "This is endpoint to add a new bomb", description = "Create request to add a new bomb", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. The new bomb is successfully created and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already exists")})
    BombDto createBomb(BombDto requestForSave);

    @Operation(summary = "This is endpoint to change bomb by ID", description = "Create request to change bomb by ID", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UPDATED. This bomb is successfully updated and added to database"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already exists")})
    Bomb putBomb(Integer id, Bomb bomb);

    @Operation(summary = "This is endpoint to view bomb by ID", description = "Create request to view bomb by ID", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK. Pls see requested bomb by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already deleted")})
    Bomb getBomb(Integer id);

    @Operation(summary = "This is endpoint to view all bombs in database", description = "Create request to view all bombs in database", tags = {"Bomb"})
    Collection<Bomb>getAllBombs();

    @Operation(summary = "This is endpoint to safe delete bomb by ID", description = "Create request to safe delete bomb by ID", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK. Pls see requested bomb by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already deleted")})
    void removeBomb(Integer id);

    @Operation(summary = "This is endpoint to delete all bombs in database", description = "NOW THIS ENDPOINT IS BLOCKED!!!", tags = {"Bomb"})
    void removeAllBombs();

    @Operation(summary = "This is endpoint to view bomb by  name", description = "Create request to view bombs by  name", tags = {"Bomb"})
    Collection<Bomb> findBombByName(String name);

    @Operation(summary = "This is endpoint to view bombs by country", description = "Create request to view bombs by country", tags = {"Bombs"})
    Collection<Bomb> findBombByCountry(String country);

    @Operation(summary = "This is endpoint to view bombs by weight", description = "Create request to view bombs by weight", tags = {"Bombs"})
    Collection<Bomb> findBombByWeight(int weight);

    @Operation(summary = "This is endpoint to view if the bombs is nuclear", description = "Create request to view if the bomb is nuclear", tags = {"Bombs"})
    Collection<Bomb> findBombByNuclear();







}
