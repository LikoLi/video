package org.liko.study.project.video.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/video")
public class VideoController {

    @Value("${video.url}")
    private String url;

    @Value("#{'${video.support-suffix}'.split(',')}")
    private List<String> supportSuffix;

    @RequestMapping("/files")
    public String getFiles(Model model) {
        File file = new File(url);
        File[] files = file.listFiles();
        Set<String> filePathSet = Arrays.stream(files).map(File::toString).filter(filePath -> supportSuffix.contains(filePath.substring(filePath.lastIndexOf(".") + 1))).collect(Collectors.toSet());
        model.addAttribute("filePathSet", filePathSet);
        return "video";
    }

    @RequestMapping("/showVideo")
    public void showVideo(HttpServletResponse response, @RequestParam("fileName")String fileName) {
        show(response,fileName,"video");
    }

    public void  show(HttpServletResponse response, String fileName,String type){
        try{
            FileInputStream fis = new FileInputStream(fileName); // 以byte流的方式打开文件
            int i=fis.available(); //得到文件大小
            byte data[]=new byte[i];
            fis.read(data);  //读数据
            response.setContentType(type+"/*"); //设置返回的文件类型
            OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象
            toClient.write(data);  //输出数据
            toClient.flush();
            toClient.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("文件不存在");
        }
    }
}
