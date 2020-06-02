package edu.dali.hotel.controller;

import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.service.RoomService;
import edu.dali.hotel.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/room")
    public String room(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("rooms", roomService.listRoom());
        return "room";
    }

//    @PostMapping("/room/search")
//    public String search(RoomQuery room, Model model) {
//        model.addAttribute(roomService.listBlog(room));
//        return "admin/blogs :: blogList";
//    }

}
