//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.http.HttpHeaders;
//
//import org.springframework.http.MediaType;
//
//import org.springframework.stereotype.Service;
//
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class AiService {
//
//    @Value("${openai.api.key}")
//
//    private String apiKey;
//
//    public String askAi(
//            String userMessage
//    ) {
//
//        try {
//
//            WebClient webClient =
//                    WebClient.builder()
//
//                            .baseUrl(
//                                    "https://api.openai.com/v1/chat/completions"
//                            )
//
//                            .defaultHeader(
//                                    HttpHeaders.AUTHORIZATION,
//                                    "Bearer " + apiKey
//                            )
//
//                            .defaultHeader(
//                                    HttpHeaders.CONTENT_TYPE,
//                                    MediaType.APPLICATION_JSON_VALUE
//                            )
//
//                            .build();
//
//            Map<String, Object> requestBody =
//                    new HashMap<>();
//
//            requestBody.put(
//                    "model",
//                    "gpt-4.1-mini"
//            );
//
//            requestBody.put(
//                    "messages",
//                    List.of(
//
//                            Map.of(
//                                    "role",
//                                    "system",
//
//                                    "content",
//
//                                    "You are an AI LMS Tutor helping students learn programming and software development."
//                            ),
//
//                            Map.of(
//                                    "role",
//                                    "user",
//
//                                    "content",
//                                    userMessage
//                            )
//                    )
//            );
//
//            Map response =
//                    webClient.post()
//
//                            .bodyValue(requestBody)
//
//                            .retrieve()
//
//                            .bodyToMono(Map.class)
//
//                            .block();
//
//            List choices =
//                    (List) response.get("choices");
//
//            Map choice =
//                    (Map) choices.get(0);
//
//            Map message =
//                    (Map) choice.get("message");
//
//            return message
//                    .get("content")
//                    .toString();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return "AI Error: "
//                    + e.getMessage();
//        }
//    }
//}