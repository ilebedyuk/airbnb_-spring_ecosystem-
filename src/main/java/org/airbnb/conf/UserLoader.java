package org.airbnb.conf;

import org.airbnb.model.AppUser;
import org.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author ilebedyuk
 */
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        AppUser appUser = new AppUser();
        appUser.setUserId((long) 1.0);
        appUser.setName("Vasya");
        userRepository.save(appUser);
    }
}
