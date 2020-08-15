package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Files;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.FilesFactory;
import com.famethe.payroll.payroll.repository.FilesRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl {

    @Autowired
    FilesFactory filesFactory;

    @Autowired
    FilesRepository filesRepository;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Files file = filesFactory.getFiles(values);
        filesRepository.save(file);
        jsonResponse.put(Constants.FILE, file);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.FILE_SUCCESS.getDescription(), jsonResponse);
    }
}
