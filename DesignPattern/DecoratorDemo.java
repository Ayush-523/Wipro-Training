package com.wipro.JavaBasics.DesignPattern;

public class DecoratorDemo {
    public static void main(String[] args) {

        File file = new BasicFile();

        // Dynamically adding features
        file = new Compression(file);
        file = new Encryption(file);
        file = new Logging(file);

        file.process();
    }
}

// Step 1: Component Interface
interface File {
    void process();
}

// Step 2: Concrete Component
class BasicFile implements File {
    public void process() {
        System.out.println("Processing basic file...");
    }
}

// Step 3: Decorator Base Class
abstract class FileDecorator implements File {
    protected File file;

    FileDecorator(File file) {
        this.file = file;
    }
}

// Step 4: Concrete Decorators

class Compression extends FileDecorator {

    Compression(File file) {
        super(file);
    }

    public void process() {
        file.process();
        System.out.println("Applying Compression...");
    }
}

class Encryption extends FileDecorator {

    Encryption(File file) {
        super(file);
    }

    public void process() {
        file.process();
        System.out.println("Applying Encryption...");
    }
}

class Logging extends FileDecorator {

    Logging(File file) {
        super(file);
    }

    public void process() {
        file.process();
        System.out.println("Adding Logging...");
    }
}