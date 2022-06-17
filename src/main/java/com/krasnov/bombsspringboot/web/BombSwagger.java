package com.krasnov.bombsspringboot.web;


import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

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

    @Operation(summary = "This is endpoint to safe delete bomb by ID", description = "Create request to safe delete bomb by ID", tags = {"Bomb"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK. Pls see requested bomb by ID"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND. Specified bomb request not found"),
            @ApiResponse(responseCode = "409", description = "Bomb already deleted")})
    void removeBomb(Integer id);

    @Operation(summary = "This is endpoint to delete all bombs in database", description = "NOW THIS ENDPOINT IS BLOCKED!!!", tags = {"Bomb"})
    void removeAllBombs(Integer id);






}
