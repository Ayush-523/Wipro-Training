//package com.example.controller;
//
//import com.example.dto.ChatRequest;
//
//import com.example.service.AiService;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//
//@RequestMapping("/ai")
//
//@CrossOrigin("*")
//
//public class AiController {
//
//    private final AiService aiService;
//
//    public AiController(
//            AiService aiService
//    ) {
//
//        this.aiService = aiService;
//    }
//
//    @PostMapping("/chat")
//
//    public String chat(
//
//            @RequestBody
//            ChatRequest request
//
//    ) {
//
//        return aiService.askAi(
//                request.getMessage()
//        );
//    }
//}