package edu.dali.hotel.controller;

import edu.dali.hotel.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("/hotel")
    public String index(HttpSession session,UserEntity user) {
        Object my = session.getAttribute("user");
        System.out.println(my);
        return "index";
    }

}
