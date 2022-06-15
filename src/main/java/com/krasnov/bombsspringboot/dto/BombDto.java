package com.krasnov.bombsspringboot.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class BombDto {

    @JsonIgnore
    public Integer id;

    @NotNull(message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    public String name;

    @NotNull(message = "Country may not be null")
    @Size(min = 2, max = 32, message = "Country must be between 2 and 32 characters long")
    public String country;

    @NotNull
    public int weight;


    @NotNull(message = "field isNuclear must be filled")
    public boolean isNuclear;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime date;

    @JsonIgnore
    public Boolean isDeleted = Boolean.FALSE;



}
