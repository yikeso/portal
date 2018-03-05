package com.bopinghui.portalbackstage.service;

import ch.qos.logback.core.util.FileUtil;
import com.bopinghui.portalbackstage.common.FileNameAndPath;
import com.bopinghui.portalbackstage.common.ServerResponse;
import com.bopinghui.portalbackstage.common.utils.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * 文件上传service
 *
 * @author kakasun
 * @create 2018-03-02 下午4:47
 */
@Service
public class UploadService {

    /**
     * 支持的图片上传格式
     */
    static final String IMAGE_SUFFIX = "gif,jpg,jpeg,bmp,png";

    static final DateTimeFormatter datePath = DateTimeFormatter.ofPattern("yyyy/MM/dd/");

    @Value("${upload.file.dir}")
    String uploadFileDir;

    @Value("${upload.image.dir}")
    String uploadImageDir;

    @Value("${upload.image.size}")
    long uploadImageSize;

    /**
     * 保存文件
     * @param files
     * @return
     * @throws IOException
     */
    public ServerResponse saveFiles(List<MultipartFile> files) throws IOException {
        List<FileNameAndPath> data = Arrays.asList();
        for(MultipartFile f : files){
            data.add(saveFile(f,uploadFileDir));
        }
        return ServerResponse.ofSucess(data);
    }

    /**
     * 保存文件返回文件名和对应储存路径
     * @param file
     * @param saveDir
     * @return
     * @throws IOException
     */
    FileNameAndPath saveFile(MultipartFile file,String saveDir) throws IOException {
        String fileName = file.getOriginalFilename();
        String savePath = saveDir + datePath.format(LocalDateTime.now()) + IdUtil.createId();
        File save = new File(savePath);
        FileUtil.createMissingParentDirectories(save);
        int index = fileName.lastIndexOf('.');
        if(index > 0){
            savePath = savePath + fileName.substring(index);
        }
       file.transferTo(save);
        return new FileNameAndPath(fileName,savePath);
    }

    /**
     * 保存图片
     * @param images
     * @return
     * @throws IOException
     */
    public ServerResponse saveImages(List<MultipartFile> images) throws IOException {
        List<FileNameAndPath> data = Arrays.asList();
        String name = null;
        long size = 0;
        String suffix = "";
        int index = 0;
        for(MultipartFile f : images){
            name = f.getOriginalFilename();
            index = name.lastIndexOf('.');
            if(index < 1){
                throw new IllegalArgumentException(name + " 图片无后缀名");
            }
            suffix = name.substring(index);
            if(suffix.length() < 2){
                throw new IllegalArgumentException(name + " 图片无后缀名");
            }
            suffix = suffix.substring(1);
            if(IMAGE_SUFFIX.indexOf(suffix) < 0){
                throw new IllegalArgumentException(name + " 图片格式不支持");
            }
            size = f.getSize();
            if(size > uploadImageSize){
                throw new IllegalArgumentException(name + " 图片超过大小");
            }
            data.add(saveFile(f,uploadImageDir));
        }
        return ServerResponse.ofSucess(data);
    }

    /**
     * 保存图片
     * @param image
     * @return
     * @throws IOException
     */
    public ServerResponse saveImage(MultipartFile image) throws IOException {
        String name = null;
        long size = 0;
        String suffix = "";
        int index = 0;
        name = image.getOriginalFilename();
        index = name.lastIndexOf('.');
        if(index < 1){
           throw new IllegalArgumentException(name + " 图片无后缀名");
        }
        suffix = name.substring(index);
        if(suffix.length() < 2){
           throw new IllegalArgumentException(name + " 图片无后缀名");
        }
        suffix = suffix.substring(1);
        if(IMAGE_SUFFIX.indexOf(suffix) < 0){
           throw new IllegalArgumentException(name + " 图片格式不支持");
        }
        size = image.getSize();
        if(size > uploadImageSize){
           throw new IllegalArgumentException(name + " 图片超过大小");
        }
        return ServerResponse.ofSucess(saveFile(image,uploadImageDir));
    }
}
