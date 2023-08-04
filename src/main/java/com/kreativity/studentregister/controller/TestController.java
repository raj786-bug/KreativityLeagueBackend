package com.kreativity.studentregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class TestController {
	@GetMapping("/form")
    public String showForm() {
      
        return "form";
    }

}
