package com.example.simple_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collections;

import static com.example.simple_app.Customer.*;

@Controller
public class ControllerSome {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    
     @GetMapping("/customers")
    public String customers(Principal principal, Model model){
        addCustomer();
        model.addAttribute("customers", customer());
        model.addAttribute("username", "ciao");
        return "customers";        
     }

    private void addCustomer() {
    }
}
