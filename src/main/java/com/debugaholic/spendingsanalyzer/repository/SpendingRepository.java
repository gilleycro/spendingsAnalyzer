package com.debugaholic.spendingsanalyzer.repository;

import com.debugaholic.spendingsanalyzer.model.Spending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends CrudRepository<Spending, Integer> {
}
