package com.hfut.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String demo(Model model) throws IOException{
        System.out.println("执行demo");
        model.addAttribute("model","我们都爱祖国");
        return "index.jsp";
    }
}
