package org.airbnb;

import org.airbnb.domain.AppUser;
import org.airbnb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


/**
 * @author ilebedyuk
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveProduct(){
        //setup product
        AppUser appUser = new AppUser();

        appUser.setName("Petya");
        //save product, verify has ID value after save
        assertNull(appUser.getUserId()); //null before save
        userRepository.save(appUser);
        assertNotNull(appUser.getUserId()); //not null after save

//        fetch from DB
        AppUser fetchedUser = userRepository.findOne(appUser.getUserId());

        //should not be null
        assertNotNull(fetchedUser);

        //should equal
        assertEquals(appUser.getUserId(), fetchedUser.getUserId());

        //update description and save
        fetchedUser.setName("11111");
        userRepository.save(fetchedUser);

        //get from DB, should be updated
        AppUser fetchedUpdatedUser = userRepository.findOne(fetchedUser.getUserId());
        assertEquals(fetchedUser.getName(), fetchedUpdatedUser.getName());

        //verify count of products in DB
        long userCount = userRepository.count();
        assertEquals(userCount, 1);

        //get all products, list should only have one
        Iterable<AppUser> products = userRepository.findAll();

        int count = 0;

        for(AppUser p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
