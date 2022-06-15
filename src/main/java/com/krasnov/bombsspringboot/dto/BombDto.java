package com.krasnov.bombsspringboot.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class BombDto {

    @JsonIgnore
    public Integer id;

    @NotNull(message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @Schema(description = "Name of bomb", example = "Iskander", required = true)
    public String name;

    @NotNull(message = "Country may not be null")
    @Size(min = 2, max = 32, message = "Country must be between 2 and 32 characters long")
    @Schema(description = "Country of bomb", example = "Ukraine", required = true)
    public String country;

    @NotNull
    public int weight;


    @NotNull(message = "field isNuclear must be filled")
    public boolean isNuclear;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Schema(description = "Produce date of bomb", example = "2022-05-16 22:12", required = true)
    public LocalDateTime date;

    @JsonIgnore
    public Boolean isDeleted = Boolean.FALSE;



}
