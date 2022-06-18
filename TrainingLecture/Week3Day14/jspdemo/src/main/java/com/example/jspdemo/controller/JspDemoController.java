package com.example.jspdemo.controller;

import com.example.jspdemo.domain.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JspDemoController {

    @GetMapping("/test-jsp")
    public String testScriptlet(Model model) {
        model.addAttribute("name", "April");
        return "jspDemo";
    }

    @GetMapping("/test-include-directive")
    public String testIncludeDirective() {
        return "directiveDemo";
    }

    @GetMapping("/test-include-action")
    public String testIncludeJspAction() {
        return "actionDemo";
    }

    @GetMapping("/test-jstl")
    public String testJstl(Model model) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("panda", 2));
        animals.add(new Animal("fox", 6));
        animals.add(new Animal("raven", 11));
        animals.add(new Animal("deer", 3));
        animals.add(new Animal("turtle", 42));
        model.addAttribute("animals", animals);
        return "jstlDemo";
    }

}
