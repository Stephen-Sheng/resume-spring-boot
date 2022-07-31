package com.resume.resumespringboot.controller;

import ch.qos.logback.core.util.FileUtil;
import com.resume.resumespringboot.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api")
public class FileController {

    @PostMapping("upload")
    public JSONResult handleFileUpload(@RequestParam("photo") MultipartFile file ) {

        String photoExtention = FilenameUtils.getExtension(file.getOriginalFilename());
        String uid = UUID.randomUUID().toString();
        String fileName = uid + "." + photoExtention;
        Map<String,String> map = new HashMap<>();
        try {
            file.transferTo( new File(new File("src/main/photo").getAbsolutePath()+ "/" + fileName));
            map.put("URL","http://localhost:8080/photo/"+fileName);
        } catch (Exception e) {
            return JSONResult.errorMsg(e.getMessage());
        }
        return JSONResult.ok(map);
    }

}
