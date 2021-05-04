package com.debugaholic.spendingsanalyzer.service;

import com.debugaholic.spendingsanalyzer.model.Spending;

import java.util.List;

public interface SpendingService {

     void saveSpendings(List<Spending> objects);
}
