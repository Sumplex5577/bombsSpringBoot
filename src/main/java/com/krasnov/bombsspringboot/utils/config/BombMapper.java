package com.krasnov.bombsspringboot.utils.config;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDeleteDto;
import com.krasnov.bombsspringboot.dto.BombDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BombMapper {
    BombMapper INSTANCE = Mappers.getMapper(BombMapper.class);
    BombDto bombToBombDto(Bomb bomb);
    Bomb bombDtoToBomb(BombDto dto);

    BombDeleteDto bombToBombDeleteDto(Bomb bomb);
}
