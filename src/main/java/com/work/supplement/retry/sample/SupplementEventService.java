package com.work.supplement.retry.sample;

import com.work.supplement.retry.sample.model.SupplementEventRecord;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplementEventService {

    @Autowired
    SupplementEventRecordRepository repository;

    @Retry(name = "eventPredicate")
    public SupplementEventRecord getSupplementRecordByIdWithRetry(Long supplementId) {
        Optional<SupplementEventRecord> recordOpt = repository.findById(supplementId);
        return recordOpt.isPresent() ? recordOpt.get() : null;
    }

    public SupplementEventRecord getSupplementRecordById(Long supplementId) {
        Optional<SupplementEventRecord> recordOpt = repository.findById(supplementId);
        return recordOpt.isPresent() ? recordOpt.get() : null;
    }

    public SupplementEventRecord saveEvent(SupplementEventRecord event) {
        return repository.save(event);
    }

    public void delete(SupplementEventRecord event) {
        repository.delete(event);
    }
}
