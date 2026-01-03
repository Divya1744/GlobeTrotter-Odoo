package com.travelplanner.odoo.controller;

import com.travelplanner.odoo.model.Trip;
import com.travelplanner.odoo.service.TripService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public List<Trip> getTrips(@RequestParam Long userId) {
        return tripService.getTrips(userId);
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) {
        return tripService.getTrip(id);
    }
}
