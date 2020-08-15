package com.famethe.payroll.payroll.controller;


import com.famethe.payroll.payroll.domain.Files;
import com.famethe.payroll.payroll.repository.FilesRepository;
import com.famethe.payroll.payroll.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "files")
public class FilesController {

    @Autowired
    FileServiceImpl fileService;

    @Resource
    FilesRepository filesRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Files findById(@PathVariable String id) throws EntityNotFoundException {
        return filesRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        filesRepository.deleteById(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return fileService.save(values);
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Files> findByEmployeeId(@PathVariable String id) throws EntityNotFoundException {
        return filesRepository.findByEmployeeId(Integer.valueOf(id));
    }

}
