package com.wipro.JavaBasics.ArrayList;

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<String> cart = new ArrayList<>();

        cart.add("Apple");
        cart.add("Banana");
        cart.add("Apple");

        cart.remove("Banana");

        System.out.println(cart);
    }
}