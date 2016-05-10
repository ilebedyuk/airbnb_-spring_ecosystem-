package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.AppUser;
import org.airbnb.repository.UserRepository;
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
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(AppUser appUser) {
        userRepository.save(appUser);
    }

    public void delete(AppUser appUser){
        userRepository.delete(appUser);
    }

    public AppUser findOne(long userId) {
        return userRepository.findOne(userId);
    }

    public Iterable<AppUser> findAll(){
        return userRepository.findAll();
    }
}
