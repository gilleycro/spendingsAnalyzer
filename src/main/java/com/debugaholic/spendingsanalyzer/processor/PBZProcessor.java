package com.debugaholic.spendingsanalyzer.processor;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;
import com.debugaholic.spendingsanalyzer.csvmappers.PBZMapper;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PBZProcessor implements Processor {

	private List<MapperObject> mapperObjects = new ArrayList<>();

	public List<MapperObject> processCSV(String fileName){
		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			reader.skip(1);
			List<String[]> r = reader.readAll();
			r.forEach(x ->{ System.out.println(Arrays.toString(x));
				mapperObjects.add(new PBZMapper(x));
			});
		} catch (Exception e){
			//TODO add meaningful exception
			log.error("CSV processing failed");
			log.error(e.getStackTrace().toString());
		}

		return mapperObjects;
	}
}
