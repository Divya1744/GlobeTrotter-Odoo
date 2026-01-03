package com.travelplanner.odoo.controller;

import com.travelplanner.odoo.dto.ItineraryDayDTO;
import com.travelplanner.odoo.service.ItineraryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/{tripId}")
    public List<ItineraryDayDTO> getItinerary(@PathVariable Long tripId) {
        return itineraryService.getItinerary(tripId);
    }
}
