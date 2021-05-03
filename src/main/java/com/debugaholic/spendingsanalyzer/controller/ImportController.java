package com.debugaholic.spendingsanalyzer.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/import")
public class ImportController {


    @PostMapping(path = "/csv",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestBody
    public void importCSV(@RequestBody String username,
                          @RequestParam("File") MultipartFile file) {

        log.info(String.format("%s  %s ", username, file.getName()));

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
