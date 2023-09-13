package com.work.supplement.retry.sample;

import com.work.supplement.retry.sample.model.SupplementEventRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplementEventRecordRepository extends JpaRepository<SupplementEventRecord, Long> {
}
