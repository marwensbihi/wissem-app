package com.app.App.controllers;

import com.app.App.models.Livreur;
import com.app.App.models.Restaurant;
import com.app.App.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestaurantC {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PostMapping("/restaurants/{restId}/livreur/{livId}")
    public Restaurant assignLivreur(@PathVariable Long restId, @PathVariable Long livId) {
        return restaurantService.assignLivreur(restId, livId);
    }
}
