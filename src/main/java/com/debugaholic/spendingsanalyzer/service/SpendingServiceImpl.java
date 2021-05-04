package com.debugaholic.spendingsanalyzer.service;

import com.debugaholic.spendingsanalyzer.model.Spending;
import com.debugaholic.spendingsanalyzer.repository.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendingServiceImpl implements SpendingService{

    private SpendingRepository spendingRepository;

    @Autowired
    public SpendingServiceImpl(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
    }

    @Override
    public void saveSpendings(List<Spending> objects) {
        objects.forEach(object -> spendingRepository.save(object));
    }
}
