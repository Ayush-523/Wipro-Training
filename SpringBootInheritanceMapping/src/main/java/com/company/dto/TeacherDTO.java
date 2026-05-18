package com.company.dto;

import java.util.List;

public record TeacherDTO(

        Long Id,

        String name,

        String city,

        String subject,

        List<String> emails

) {
}