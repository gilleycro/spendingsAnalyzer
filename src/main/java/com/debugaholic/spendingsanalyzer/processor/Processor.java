package com.debugaholic.spendingsanalyzer.processor;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;
import com.debugaholic.spendingsanalyzer.exception.CSVParsingFailedException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface Processor {

	List<MapperObject> processCSV(String fileName) throws CSVParsingFailedException;
	List<MapperObject> processCSV(MultipartFile fileName) throws CSVParsingFailedException;

}
