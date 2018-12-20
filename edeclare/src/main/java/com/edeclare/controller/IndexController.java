package com.edeclare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Type: IndexController
* Description: Index,所有uri路径不允许有大写字母
* @author LYM
* @date Dec 16, 2018
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String defaultPage() {
        return "redirect:/login";
    }


}
