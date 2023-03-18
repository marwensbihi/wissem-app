package com.app.App.services;

import com.app.App.models.Gerant;
import com.app.App.models.Restaurant;
import com.app.App.repositories.LivreurRepo;
import com.app.App.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    LivreurRepo livreurRepo;

    public List<Restaurant> getAll() {
        return restaurantRepo.findAll();
    }

    public Restaurant getById(Long id) {
        return restaurantRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Restaurant with id: " + id + " does not exist"));
    }

    public boolean deleteById(Long id) {
        if (restaurantRepo.existsById(id)) {
            restaurantRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean deleteAll() {
        restaurantRepo.deleteAll();
        return true;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurant.setId(null);
        return restaurantRepo.save(restaurant);
    }

    public Restaurant assignLivreur(Long restId, Long livId) {
        Restaurant restaurant = restaurantRepo.findById(restId).orElseThrow(() -> new IllegalStateException("Restaurant with id:" + restId + " does not exist"));
        livreurRepo.findById(livId).orElseThrow(() -> new IllegalStateException("Livreur with id:" + livId + " does not exist"));
        restaurant.setLivreur_id(livId);
        return restaurantRepo.save(restaurant);
    }
}
