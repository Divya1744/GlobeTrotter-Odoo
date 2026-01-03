package com.travelplanner.odoo.service;

import com.travelplanner.odoo.model.TripStop;
import com.travelplanner.odoo.repository.TripStopRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripStopService {

    private final TripStopRepository stopRepository;

    public TripStopService(TripStopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public TripStop addStop(TripStop stop) {
        return stopRepository.save(stop);
    }

    public List<TripStop> getStops(Long tripId) {
        return stopRepository.findByTripIdOrderBySequenceOrder(tripId);
    }
}
