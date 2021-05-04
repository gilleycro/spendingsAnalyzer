package com.debugaholic.spendingsanalyzer.service;

import com.debugaholic.spendingsanalyzer.csvmappers.MapperObject;
import com.debugaholic.spendingsanalyzer.exception.CSVParsingFailedException;
import com.debugaholic.spendingsanalyzer.model.Spending;
import com.debugaholic.spendingsanalyzer.processor.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@Service
public class CSVProcessFileService implements ProcessFileService {

    private Processor processor;

    @Autowired
    public CSVProcessFileService(Processor processor) {
        this.processor = processor;
    }

    @Override
    public List<Spending> processFile(String username, MultipartFile file) {
        List<MapperObject> objects = new ArrayList<>();

        try {
            objects = processor.processCSV(file);
        } catch (CSVParsingFailedException exception) {
            log.error(exception.getMessage());
            log.error(exception.getStackTrace().toString());
        }
        return mapToSpending(username, objects);
    }

    private List<Spending> mapToSpending(String username, List<MapperObject> objects) {
        List<Spending> spendings = new ArrayList<>();

        objects.forEach(object -> {
            Spending spending = new Spending();
            spending.setId(100); //mocked for now
            spending.setDate(object.getDate());
            spending.setAmount(object.getValue());

            spendings.add(spending);
        });


        return spendings;
    }
}
