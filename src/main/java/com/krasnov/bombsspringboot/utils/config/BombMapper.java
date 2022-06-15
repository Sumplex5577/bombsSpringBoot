package com.krasnov.bombsspringboot.utils.config;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDeleteDto;
import com.krasnov.bombsspringboot.dto.BombDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;



public class BombMapper extends CustomMapper<Bomb, BombDto> {

    @Override
    public void mapBtoA(BombDto dto, Bomb entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
