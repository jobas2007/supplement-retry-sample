package com.work.supplement.retry.sample;

import com.work.supplement.retry.sample.model.SupplementEventRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SupplementEventController {

    @Autowired
    SupplementEventService service;

    @GetMapping("/events/{id}")
    public ResponseEntity<SupplementEventRecord> getSupplementRecordByIdWithRetry(@PathVariable(value = "id") Long supplementId) {
        SupplementEventRecord event = service.getSupplementRecordByIdWithRetry(supplementId);
        return ResponseEntity.ok().body(event);
    }

    @PostMapping("/events")
    public SupplementEventRecord createSupplementEvent(@RequestBody SupplementEventRecord event) {
        return service.saveEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Long supplementId) {
        SupplementEventRecord event = service.getSupplementRecordById(supplementId);
        service.delete(event);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
