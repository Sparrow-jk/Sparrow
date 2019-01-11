package com.sparrow.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sparrow
 */
@Controller
public class IndexController {
    @RequestMapping(value ="toIndex")
    public String toIndex() {
        return "index";
    }
}
