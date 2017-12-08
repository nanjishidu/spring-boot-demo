package com.example.controller.upload;

import com.example.controller.common.ApiResult;
import com.example.controller.common.ExceptionManager;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 文件上传下载
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */

@CrossOrigin
@RestController
@RequestMapping(value="/api/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    ExceptionManager exceptionManager;

    @Value("${upload.dir}")
    private String UPLOADED_DIR;

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ApiOperation(value="上传图片到指定的路径下", notes = "上传图片到指定的路径下", response = ApiResult.class)
    public ApiResult img(@RequestParam(value = "filename") MultipartFile file) {
        if (file.isEmpty()){
            throw exceptionManager.create("EC10007");
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传文件名"+fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传文件后缀"+suffixName);
        if (!this.checkExt(suffixName)){
            throw exceptionManager.create("EC10008");
        }

        fileName = UUID.randomUUID() + suffixName;
        logger.info("上传后文件名"+fileName);

        String subName = this.getSubDir()+fileName;
        File dest = new File(UPLOADED_DIR + subName);
        //检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiResult.jdata("/"+subName);
    }
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ApiOperation(value="上传文件到指定的路径下", notes = "上传文件到指定的路径下", response = ApiResult.class)
    public ApiResult file(@RequestParam(value = "filename") MultipartFile file) {
        if (file.isEmpty()){
            throw exceptionManager.create("EC10007");
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传文件名"+fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传文件后缀"+suffixName);
        fileName = UUID.randomUUID() + suffixName;
        logger.info("上传后文件名"+fileName);

        String subName = this.getSubDir()+fileName;
        File dest = new File(UPLOADED_DIR , subName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiResult.jdata("/"+subName);
    }


    private String exts = ".jpg|.png|.git|.jpeg";

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    /**
     * 检查上传的文件后缀是否合法
     *
     */
    private boolean checkExt(String ext){
        if(this.getExts().isEmpty()){
            return true;
        }else{
            if(this.getExts().indexOf(ext) != -1){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否生成子目录，返回子目录名称
     *
     */
    private String getSubDir(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM");// 设置日期格式
        return df.format(new Date())+ "/";
    }



}
