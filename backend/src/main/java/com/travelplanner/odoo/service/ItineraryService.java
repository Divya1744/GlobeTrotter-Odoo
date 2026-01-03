package com.travelplanner.odoo.service;

import com.travelplanner.odoo.dto.ItineraryDayDTO;
import com.travelplanner.odoo.model.TripStop;
import com.travelplanner.odoo.repository.TripStopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItineraryService {

    private final TripStopRepository stopRepository;

    public ItineraryService(TripStopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<ItineraryDayDTO> getItinerary(Long tripId) {
        List<TripStop> stops = stopRepository.findByTripIdOrderBySequenceOrder(tripId);
        List<ItineraryDayDTO> result = new ArrayList<>();

        for (TripStop stop : stops) {
            LocalDate date = stop.getStartDate();
            while (!date.isAfter(stop.getEndDate())) {
                result.add(new ItineraryDayDTO(date, stop.getCity()));
                date = date.plusDays(1);
            }
        }
        return result;
    }
}
