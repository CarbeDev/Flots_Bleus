package com.simplon.course_voilier.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;


    
    @Controller
    public class PreAcceuilController {
    
        @GetMapping("/preacceuil")
        public String getpreacceuil() { 
            return "publicTemplates/preacceuil";
        }
        
        }
