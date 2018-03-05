package com.bopinghui.portalbackstage.controllers;

import com.bopinghui.portalbackstage.common.ServerResponse;
import com.bopinghui.portalbackstage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传控制层
 *
 * @author kakasun
 * @create 2018-03-02 下午4:25
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/")
    public ServerResponse uploadFiles(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        return uploadService.saveFiles(files);
    }

    @PostMapping("/image")
    public ServerResponse uploadImages(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        return uploadService.saveImages(files);
    }
    @PostMapping("/singleimage")
    public ServerResponse uploadSingleImages(MultipartFile file) throws IOException {
        return uploadService.saveImage(file);
    }

}
