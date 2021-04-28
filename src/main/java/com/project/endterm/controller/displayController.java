package com.project.endterm.controller;

import com.project.endterm.model.user;
import com.project.endterm.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class displayController {

    @Autowired
    private userService userService;

    @RequestMapping("/display")
    public String display(Model model){
        List<user> users = userService.getAllUserInfo();
        model.addAttribute("user", new user());
        model.addAttribute("users",users);
        return "display";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String search(@RequestParam("name") String userName,Model model ,RedirectAttributes redirAttrs){
        user user = new user();
        if(userService.check(userName)){
            user = userService.getUser(userName);
            model.addAttribute("user",user);
            return "search";
        } else {
            redirAttrs.addFlashAttribute("notfound","User Not Found");
            return "redirect:/display";
        }
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/edituser")
    public String editUser(@RequestParam(name = "userId") Integer userId, user updateuser, RedirectAttributes redirAttrs){
        updateuser.setId(userId);
        userService.updateUser(updateuser);
        redirAttrs.addFlashAttribute("success","User Edited Successfully");
        return "redirect:/display";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser")
    public String deletePost(@RequestParam(name = "userId") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/display";
    }

}
