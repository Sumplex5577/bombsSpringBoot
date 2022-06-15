package com.krasnov.bombsspringboot.utils.config;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class MappingConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Bomb.class, BombDto.class)
                .customize(new BombMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(Bomb.class, BombDto.class)
                .byDefault()
                .register();
    }
}
