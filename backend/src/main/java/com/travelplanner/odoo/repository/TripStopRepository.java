package com.travelplanner.odoo.repository;

import com.travelplanner.odoo.model.TripStop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripStopRepository extends JpaRepository<TripStop, Long> {
    List<TripStop> findByTripIdOrderBySequenceOrder(Long tripId);
}
