package com.pablosaraiva.web.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String getIndex(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("principalName", principal.getName());
        }

        return "index";
    }
}
