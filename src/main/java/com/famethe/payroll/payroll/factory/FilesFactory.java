package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Files;
import com.famethe.payroll.payroll.domain.Platform;
import com.famethe.payroll.payroll.repository.FilesRepository;
import com.famethe.payroll.payroll.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class FilesFactory {

    Files files;
    Platform platform;

    @Resource
    PlatformRepository platformRepository;

    @Resource
    FilesRepository filesRepository;

    public Files getFiles(Map<String, Object> values){
        platform = platformRepository.getOne(1);
        if (values.get("id") == null){
            files = new Files();
        }else{
            files = filesRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }

        files.setEmployeeId(Integer.parseInt(String.valueOf(values.get("employeeId"))));
        files.setName((String) values.get("name"));
        files.setPath((String) values.get("path"));
        files.setUrl(files.getPath() + "/" + files.getName());
        return files;
    }

}
