package com.debugaholic.spendingsanalyzer.processor;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;
import com.debugaholic.spendingsanalyzer.csvmappers.PBZMapper;
import com.debugaholic.spendingsanalyzer.exception.CSVParsingFailedException;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PBZProcessor implements Processor {

    private List<MapperObject> mapperObjects = new ArrayList<>();

    public List<MapperObject> processCSV(String fileName) throws CSVParsingFailedException {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            reader.skip(1);
            List<String[]> r = reader.readAll();
            r.forEach(x -> {
                System.out.println(Arrays.toString(x));
                mapperObjects.add(new PBZMapper(x));
            });
        } catch (Exception e) {
            //TODO add meaningful exception
            log.error("CSV processing failed");
            log.error(e.getStackTrace().toString());
        }
        return mapperObjects;
    }

    @Override
    public List<MapperObject> processCSV(MultipartFile fileName) throws CSVParsingFailedException {
        try (CSVReader reader = new CSVReader(new InputStreamReader(fileName.getInputStream()))) {
            reader.skip(1);
            List<String[]> r = reader.readAll();
            r.forEach(x -> {
                System.out.println(Arrays.toString(x));
                mapperObjects.add(new PBZMapper(x));
            });
        } catch (Exception e) {
            //TODO add meaningful exception
            log.error("CSV processing failed");
            e.printStackTrace();
        }
        return mapperObjects;
    }
}
