package com.debugaholic.spendingsanalyzer;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;
import com.debugaholic.spendingsanalyzer.exception.CSVParsingFailedException;
import com.debugaholic.spendingsanalyzer.processor.PBZProcessor;
import com.debugaholic.spendingsanalyzer.processor.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

public class PBZProcessorTest {

	private Processor processor;
	@BeforeEach
	void initUseCase() {
		processor = new PBZProcessor();
	}

	@Test
	public void testProcessorWithDummyCSV() throws CSVParsingFailedException {
		List<MapperObject> mapperObject = processor.processCSV("src/main/resources/test.csv");
		Assert.notEmpty(mapperObject, "List of mapper objects must not be empty");
	}
}
