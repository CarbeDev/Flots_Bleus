package com.simplon.course_voilier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class AcceuiController {
        @GetMapping("/acceuil")
        public String getacceuil() {
            return "PublicTemplates/acceuil";
            
        }
    }
