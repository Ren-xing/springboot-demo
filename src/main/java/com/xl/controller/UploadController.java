package com.xl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping
public class UploadController {

    /**
     * 单文件上传并保存
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }

    /**
     * 多文件上传并保存
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiles(@RequestParam("file") MultipartFile[] files) {
        if (files.length == 0) {
            return "请选择上传的文件";
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isEmpty()) {
                return "第" + i + "个文件上传失败，请选查询上传该文件";
            }
            String fileName = files[i].getOriginalFilename();
            String filePath = "D:/";
            File dest = new File(filePath + fileName);
            try {
                files[i].transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传成功！";
    }
}
