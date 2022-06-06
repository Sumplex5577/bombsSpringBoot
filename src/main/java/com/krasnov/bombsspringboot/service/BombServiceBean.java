package com.krasnov.bombsspringboot.service;

import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.repository.BombRepository;
import com.krasnov.bombsspringboot.util.ResourceNotExistException;
import com.krasnov.bombsspringboot.util.ResourceNotFoundException;
import com.krasnov.bombsspringboot.util.ResourceWasDeletedException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BombServiceBean implements BombService {

    private final BombRepository bombRepository;

    @Override
    public Bomb create(Bomb bomb) {
        //checkDate(bomb);
        return bombRepository.save(bomb);
    }

    @Override
    public List<Bomb> view() {
        return bombRepository.findAll();
    }

    @Override
    public Bomb viewById(Integer id) {
       log.info("viewById() - start: id = {}", id);
        Bomb bomb = getBomb(id);
        log.debug("viewById()->checkDeleted() - start: id = {}", id);
        checkDeleted(bomb);
        return getBomb(id);
    }

    private void checkDeleted(Bomb bomb) {
       log.info("checkDeleted() - start: id = {}", bomb.getId());
        if (bomb.getDeleted() == null || bomb.getDeleted()) {
            throw new EntityNotFoundException("Bomb was Deleted");
        }
    }
    private Bomb getBomb(Integer id) {
        return bombRepository.findById(id)
                //.orElseThrow(() -> new EntityNotFoundException("Bomb not found with id = " + id));
                .orElseThrow(ResourceWasDeletedException::new);

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
                .orElseThrow(() -> new EntityNotFoundException("Bomb not found with id = " + id));
    }

    @Override
    public void delete(Integer id) {
//        Bomb bomb = getBomb(id);
//        bomb.setDeleted(Boolean.TRUE);
//        bombRepository.save(bomb);
        Bomb bomb = bombRepository.findById(id).orElseThrow(ResourceNotExistException::new);
        checkDeleted(bomb);
        bomb.setDeleted(Boolean.TRUE);
        bombRepository.save(bomb);
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


//    private void checkDate(Bomb bomb) {
//        if (bomb.getDate().isBefore(ChronoLocalDateTime.from(LocalDate.of(12, 5, 3)))) {
//            throw new RuntimeException("Bomb is very old, you can't use it!");
//        }



    /**
     * techinal method that return Bomb by id or throw EntityNotFoundException
     * @param id - id of bomb that should be returned
     * @return
     */

    private Bomb returnBomb(Integer id) {
        return bombRepository.findById(id)
                //.orElseThrow(() -> new EntityNotFoundException("Bomb with such id doesn't exist"));
                .orElseThrow(ResourceNotFoundException::new);

    }
}





