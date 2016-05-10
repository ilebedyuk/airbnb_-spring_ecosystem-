package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.Apartament;
import org.airbnb.repository.ApartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilebedyuk
 */
@Service
@NoArgsConstructor
@Data
@Transactional
public class ApartamentService {

    @Autowired
    ApartamentRepository apartamentRepository;

    public void save(Apartament apartament) {
        apartamentRepository.save(apartament);
    }

    public void delete(Apartament apartament){
        apartamentRepository.delete(apartament);
    }

    public Apartament findOne(long apartamentId) {
        return apartamentRepository.findOne(apartamentId);
    }

    public Iterable<Apartament> findAll(){
        return apartamentRepository.findAll();
    }
}
