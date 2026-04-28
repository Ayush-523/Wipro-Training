package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;

class Student1 {
    String name;
    String id;

    Student1(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

public class Demo3WithLambda {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a name :");
        String name = sc.nextLine();

        System.out.println("Enter a ID :");
        String id = sc.nextLine();

        Supplier<Student1> supplier = () -> new Student1(name, id);
        Student1 s = supplier.get();

        Consumer<Student1> consumer = x -> System.out.println(x);
        consumer.accept(s);

        System.out.println("Enter a string to check:");
        String input = sc.nextLine();

        Predicate<String> predicate = str -> str.startsWith("s");
        System.out.println(predicate.test(input));

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        Function<Integer, String> function = n -> "Square is: " + (n * n);
        System.out.println(function.apply(num));

        sc.close();
    }
}