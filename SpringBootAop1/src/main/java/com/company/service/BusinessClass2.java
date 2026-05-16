package com.company.service;

import org.springframework.stereotype.Service;

import com.company.myannotation.MyAnno;

@Service
public class BusinessClass2 {

    @MyAnno
    public void view() {

        System.out.println(
                "Viewing the report from BusinessClass2");
    }
}