package com.debugaholic.spendingsanalyzer.processor;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;

import java.util.List;

public interface Processor {

	List<MapperObject> processCSV(String fileName);
}
