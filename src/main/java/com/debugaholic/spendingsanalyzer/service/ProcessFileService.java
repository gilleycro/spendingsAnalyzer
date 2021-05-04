package com.debugaholic.spendingsanalyzer.service;

import com.debugaholic.spendingsanalyzer.model.Spending;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ProcessFileService {

    List<Spending> processFile(String username, MultipartFile file);
}
