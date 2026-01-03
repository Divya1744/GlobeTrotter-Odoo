package com.travelplanner.odoo.service;

import com.travelplanner.odoo.model.Trip;
import com.travelplanner.odoo.repository.TripRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getTrips(Long userId) {
        return tripRepository.findByUserId(userId);
    }

    public Trip getTrip(Long id) {
        return tripRepository.findById(id).orElseThrow();
    }
}
