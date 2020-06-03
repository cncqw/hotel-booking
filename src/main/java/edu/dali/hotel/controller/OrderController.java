package edu.dali.hotel.controller;

import edu.dali.hotel.model.OrderEntity;
import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.model.UserEntity;
import edu.dali.hotel.service.OrderService;
import edu.dali.hotel.service.RoomService;
import edu.dali.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/hotel")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;


    @GetMapping("/booking/{id}")
    public String booking(@PathVariable Integer id,
                          RoomEntity room,
                          Model model) {
        model.addAttribute("room", roomService.getRoomById(id));
        return "booking";
    }

    @PostMapping("/order/{id}")
    public String post(@PathVariable Integer id,
                       OrderEntity order,
                       RedirectAttributes attributes,
                       HttpSession session) {

        OrderEntity o;
        order.setRoom(roomService.getRoomById(id));
        order.setUser((UserEntity) session.getAttribute("user"));
        o = orderService.saveOrder(order);

        if (o == null) {
            attributes.addFlashAttribute("message", "预订失败");
            return "redirect:/hotel/room";
        } else {
            attributes.addFlashAttribute("message", "预订成功");
            return "redirect:/hotel/order/message";
        }

    }

    @GetMapping("/order/message")
    public String messagePage() {
        return "success";
    }
}
