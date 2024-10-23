package com.education.ztu;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public boolean engineIsRunning() {
        return engine.engineWorks;
    }

    public class Engine {
        private boolean engineWorks = false;

        public void startEngine() {
            engineWorks = true;
            System.out.println("Двигун запущено.");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("Двигун зупинено.");
        }
    }
}