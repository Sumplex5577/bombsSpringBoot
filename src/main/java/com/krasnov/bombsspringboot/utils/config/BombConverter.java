package com.krasnov.bombsspringboot.utils.config;


import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

@Component
public class BombConverter  {
    private final MapperFacade mapperFacade;

    public BombConverter(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }
    public MapperFacade getMapperFacade(){
        return mapperFacade;
    }
    public BombDto toDto(Bomb entity) {
        return mapperFacade.map(entity, BombDto.class);
    }

    public Bomb fromDto(BombDto dto) {
        return mapperFacade.map(dto, Bomb.class);
    }
}
