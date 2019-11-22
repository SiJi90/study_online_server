package com.example.controller;


import com.example.beans.Courseware;
import com.example.service.CoursewareService;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/courseware")
public class CoursewareController {

    @Autowired
    private CoursewareService coursewareService;

    @PostMapping("add")
    public String add(@RequestParam MultipartFile file) {
        System.out.println("收到上传文件请求");
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
        File savePath = new File("E:\\IDEAWorkspace\\study_online\\src\\main\\resources\\static");
        Instant time = Instant.now();
        long name = time.toEpochMilli();
        String url = savePath + "\\" + name + "." + fileName;
        if (!new File(url).exists()) {
            File file1 = new File(url);
            try {
                file.transferTo(file1);
                System.out.println(url);
                transcoding(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return url;
    }

    // 视频转码
    public void transcoding(String oldPath) {
        List<String> command = new LinkedList<>();
        command.add("-i");
        command.add(oldPath);
        command.add("-y");
        String newPath = oldPath.substring(0, oldPath.lastIndexOf("."));
        newPath = newPath + ".mp4";
        command.add(newPath);
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            Process process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取所有的课件列表
     *
     * @return list 课件列表
     */
    @GetMapping
    public Msg getCoursewareList() {
        List<Courseware> list = coursewareService.list();
        return Msg.success().add("list", list);
    }

    /**
     * 单个删除
     *
     * @param id 删除课件id
     * @return 成功 | 失败 信息
     */
    @DeleteMapping
    public Msg delOne(Integer id) {
        boolean res = coursewareService.removeById(id);
        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

}

