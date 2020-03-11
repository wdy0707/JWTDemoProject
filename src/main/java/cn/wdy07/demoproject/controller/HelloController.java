package cn.wdy07.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wdy
 * @create 2020-03-06 16:35
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping("/ok")
    @ResponseBody
    public String hello(){
        return "HelloWord";
    }

}
