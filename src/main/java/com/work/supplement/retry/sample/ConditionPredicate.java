package com.work.supplement.retry.sample;

import com.work.supplement.retry.sample.model.SupplementEventRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Predicate;

public class ConditionPredicate implements Predicate<SupplementEventRecord> {

    @Autowired
    @Override
    public boolean test(SupplementEventRecord event) {
        System.out.println("Condition predicate is called for event.");
        return event == null ? true : false;
    }
}