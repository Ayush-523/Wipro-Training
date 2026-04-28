package com.wipro.JavaBasics.ArrayList;


import java.util.*;

public class MovieWatchlist {
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>(Arrays.asList("Avengers", "Inception", "Titanic"));

        String search = "Inception";

        if (movies.contains(search))
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}