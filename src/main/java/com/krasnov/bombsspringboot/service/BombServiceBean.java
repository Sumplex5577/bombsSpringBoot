package com.krasnov.bombsspringboot.service;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.repository.BombRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BombServiceBean implements BombService {

    private final BombRepository bombRepository;

    public BombServiceBean(BombRepository bombRepository) {
        this.bombRepository = bombRepository;
    }
    @Override
    public Bomb create(Bomb bomb) {
        return bombRepository.save(bomb);
    }

    @Override
    public List<Bomb> view() {
        return bombRepository.findAll();
    }

    @Override
    public Bomb viewById(Integer id) {
        Bomb bomb = bombRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bomb was not found with id = " + id));
        if(bomb.getDeleted() || bomb.getDeleted()==null) { //в чем разница между двойным == and equals
            throw new EntityNotFoundException("Bomb was Deleted");
        }
        return bomb;
    }

    @Override
    public Bomb update(Integer id, Bomb bomb) {
        return bombRepository.findById(id)
                .map(entity -> {
                    entity.setName(bomb.getName());
                    entity.setCountry(bomb.getCountry());
                    entity.setDate(bomb.getDate());
                    entity.setWeight(bomb.getWeight());
                    return bombRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    @Override
    public void delete(Integer id) {
        Bomb bomb = bombRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Bomb not found with id = " + id));
        bomb.setDeleted(Boolean.TRUE);
        bombRepository.save(bomb);

        //        bombRepository.deleteById(id);
    }


    @Override
    public void deleteAll() {
        bombRepository.deleteAll();
    }

    @Override
    public Collection<Bomb> findBombByName(String name) {
        log.info("findBombByName () - start: name = {}", name);
        Collection<Bomb> collection = bombRepository.findByName(name);
        log.info("findBombByName() - end: collection = {}", collection);
        return collection;

    }
    @Override
    public Collection<Bomb> findBombByCountry(String country) {
        log.info("findBombByCountry () - start: name = {}", country);
        Collection<Bomb> collection = bombRepository.findByCountry(country);
        log.info("findBombByCountry() - end: collection = {}", collection);
        return collection;

    }

    @Override
    public Collection<Bomb> findBombByWeight(int weight) {
        log.info("findBombByWeight () - start: name = {}", weight);
        Collection<Bomb> collection = bombRepository.findByWeight(weight);
        log.info("findBombByWeight() - end: collection = {}", collection);
        return collection;
    }
    @Override
    public Collection<Bomb> findBombByNuclear() {
        log.info("findBombByNuclear() - start:");
        Collection<Bomb> collection = bombRepository.findByNuclear();
        log.info("findBombByNuclear() - end: collection = {}", collection);
        return collection;
    }


    private void checkDate(Bomb bomb) {
        if (bomb.getDate().isBefore(ChronoLocalDateTime.from(LocalDate.of(12,5,3)))){
            throw new RuntimeException("Bomb is very old, you can't use it!");


        }
    }
}

