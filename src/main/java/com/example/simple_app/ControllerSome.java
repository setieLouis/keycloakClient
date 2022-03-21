package com.example.simple_app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.IDToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import static com.example.simple_app.Customer.*;

@Controller
public class ControllerSome {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    
     @GetMapping("/customers")
    public String customers(Principal principal, Model model) throws JsonProcessingException {
        IDToken idtoken =  ((KeycloakPrincipal) principal).getKeycloakSecurityContext().getIdToken();
        new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(idtoken);
        model.addAttribute("token",body(idtoken));
        model.addAttribute( "username", "ciao");
        return "customers";        
     }

    private String body(IDToken idtoken) {

        StringBuffer bf = new StringBuffer("{\n");
        bf.append(singleOne("name", idtoken.getGivenName()));
        bf.append(singleOne("username", idtoken.getPreferredUsername()));
        bf.append(singleOne("luckyNUmber", idtoken.getOtherClaims().get("MyLuckyNumber").toString()));
        bf.append("}");
        return bf.toString();
    }



    private String singleOne(String name , String value){
         return "\"" + name + "\":" + " \""+ value + "\",\n";
    }
}
