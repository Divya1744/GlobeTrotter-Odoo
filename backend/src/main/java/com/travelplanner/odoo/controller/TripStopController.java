package com.travelplanner.odoo.controller;

import com.travelplanner.odoo.model.TripStop;
import com.travelplanner.odoo.service.TripStopService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stops")
public class TripStopController {

    private final TripStopService stopService;

    public TripStopController(TripStopService stopService) {
        this.stopService = stopService;
    }

    @PostMapping
    public TripStop addStop(@RequestBody TripStop stop) {
        return stopService.addStop(stop);
    }

    @GetMapping("/{tripId}")
    public List<TripStop> getStops(@PathVariable Long tripId) {
        return stopService.getStops(tripId);
    }
}
