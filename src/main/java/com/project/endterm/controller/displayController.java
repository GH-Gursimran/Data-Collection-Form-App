package com.project.endterm.controller;

import com.project.endterm.model.user;
import com.project.endterm.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class displayController {

    @Autowired
    private userService userService;

    @RequestMapping("/display")
    public String display(Model model){
        List<user> users = userService.getAllUserInfo();
        model.addAttribute("users",users);
        return "display";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edituser")
    public String editPost(@RequestParam(name = "userId") Integer userId, user updateuser){
        updateuser.setId(userId);
        userService.updatePost(updateuser);
        return "redirect:/display";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser")
    public String deletePost(@RequestParam(name = "userId") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/display";
    }
}
