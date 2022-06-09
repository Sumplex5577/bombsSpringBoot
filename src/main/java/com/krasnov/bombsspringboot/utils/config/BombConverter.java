package com.krasnov.bombsspringboot.utils.config;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDeleteDto;
import com.krasnov.bombsspringboot.dto.BombDto;
import ma.glasnost.orika.MapperFacade;

public class BombConverter {
    private final MapperFacade mapperFacade;

    public BombConverter(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }
    public BombDto toDto(Bomb entity){
        return mapperFacade.map(entity,BombDto.class);
    }
    public BombDeleteDto toDeleteDto(Bomb entity){
        return mapperFacade.map(entity, BombDeleteDto.class);
    }
    public Bomb fromDto(BombDto dto) {
        return mapperFacade.map(dto, Bomb.class);
    }
}
