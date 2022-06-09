package com.krasnov.bombsspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class BombDeleteDto {
    @JsonIgnore
    @NotNull
    public Integer id;

    public String message = String.format("Bomb with id = %d was deleted successfully", id);
}
