package kr.protest.multichat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/chatlist")
    public String chatlist(){

        return "chatlist";
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }
}
