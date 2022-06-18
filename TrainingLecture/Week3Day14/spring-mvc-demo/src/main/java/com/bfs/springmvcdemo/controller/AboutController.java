package com.bfs.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

    @RequestMapping(value = "/about")
    public ModelAndView aboutModelView(Model model) {
        model.addAttribute("interests", "badminton, drawing, game dev, cooking!");
        return new ModelAndView("about");
    }

    @GetMapping(value = "/about2")
    public String getAbout(Model model) {
        model.addAttribute("interests", "badminton, drawing, game dev, cooking!");
        model.addAttribute("food", "ramen");
        model.addAttribute("abc", "123");
        return "about";
    }
}
