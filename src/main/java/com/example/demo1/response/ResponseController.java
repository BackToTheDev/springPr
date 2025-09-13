package com.example.demo1.response;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    // Content-Type: text/html
    // Response Body
    // {"name":"Robbie", "age",:95
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // ConTent-Type: application/json
    //Response Body
    //{"name":"Robbie", "age":95}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClass() {
        return new Star("Robbie", 95);
    }
}
