package edu.dali.hotel.controller;

import edu.dali.hotel.model.UserEntity;
import edu.dali.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if(session.getAttribute("user") != null){
            return  "redirect:/hotel";
        }
        return "login";
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session,
                            RedirectAttributes attributes) {
        UserEntity user = userService.checkUser(username,password);
       if (user != null){
           user.setPassword(null);
           session.setAttribute("user",user);
           return  "redirect:/hotel";
       }else{
           attributes.addFlashAttribute("message", "用户名和密码错误");
           return "redirect:/login";
       }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
