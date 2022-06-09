package com.krasnov.bombsspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BombDeleteDto {
    @JsonIgnore
    public Integer id;

    public String message = String.format("Bomb with id = id was deleted", id);
}
