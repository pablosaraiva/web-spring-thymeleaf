package com.pablosaraiva.web.webcontrollers;

import com.pablosaraiva.web.core.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetaController {

    private final VisitorService visitorService;

    public MetaController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/meta")
    public String getMeta(Model model) {
        model.addAttribute("visitor", visitorService.countAndGetVisitor());
        return "meta";
    }
}
