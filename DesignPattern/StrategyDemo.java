package com.wipro.JavaBasics.DesignPattern;


public class StrategyDemo {
    public static void main(String[] args) {

        NavigationContext navigation = new NavigationContext();

        navigation.setRouteStrategy(new FastestRoute());
        navigation.buildRoute("A", "B");

        navigation.setRouteStrategy(new ShortestRoute());
        navigation.buildRoute("A", "B");

        navigation.setRouteStrategy(new AvoidTollsRoute());
        navigation.buildRoute("A", "B");
    }
}

// Step 1: Strategy Interface
interface RouteStrategy {
    void buildRoute(String source, String destination);
}

// Step 2: Concrete Strategies

class FastestRoute implements RouteStrategy {
    public void buildRoute(String source, String destination) {
        System.out.println("Calculating fastest route from " + source + " to " + destination);
    }
}

class ShortestRoute implements RouteStrategy {
    public void buildRoute(String source, String destination) {
        System.out.println("Calculating shortest route from " + source + " to " + destination);
    }
}

class AvoidTollsRoute implements RouteStrategy {
    public void buildRoute(String source, String destination) {
        System.out.println("Calculating route avoiding tolls from " + source + " to " + destination);
    }
}

// Step 3: Context Class
class NavigationContext {

    private RouteStrategy strategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void buildRoute(String source, String destination) {
        if (strategy == null) {
            System.out.println("No route strategy selected!");
            return;
        }
        strategy.buildRoute(source, destination);
    }
}