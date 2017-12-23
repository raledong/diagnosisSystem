package cn.nju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    @RequestMapping("/hello")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"/newLogin";
    }

}