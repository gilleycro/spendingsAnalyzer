package com.debugaholic.spendingsanalyzer.controller;

import com.debugaholic.spendingsanalyzer.csvmappers.enums.ProcessorType;
import com.debugaholic.spendingsanalyzer.service.ProcessFileService;
import com.debugaholic.spendingsanalyzer.service.SpendingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/import")
public class ImportController {

    private ProcessFileService processFileService;
    private SpendingService spendingService;

    @Autowired
    public ImportController(ProcessFileService processFileService, SpendingService spendingService) {
        this.processFileService = processFileService;
        this.spendingService = spendingService;
    }

    @PostMapping(path = "/csv",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestBody
    public void importCSV(@RequestBody String username,
                          @RequestBody ProcessorType processorType,
                          @RequestParam("File") MultipartFile file) {

        spendingService.saveSpendings(processFileService.processFile(username, file));

    }

    @PostMapping(path = "/test2",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestBody
    public void importCSV(@RequestPart(required = true) MultipartFile file) {

        log.info(String.format("%s  ", file.getName()));

    }

    @GetMapping("/test")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestBody
    public void test(@RequestBody String username) {

        log.info(String.format("%s  ", username));

    }

}
