package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.User;
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

    public void save(User appUser) {
        userRepository.save(appUser);
    }

    public void delete(User appUser){
        userRepository.delete(appUser);
    }

    public User findOne(long userId) {
        return userRepository.findOne(userId);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }
}
