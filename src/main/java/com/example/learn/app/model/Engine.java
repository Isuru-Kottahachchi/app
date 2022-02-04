package com.example.learn.app.model;

public class Engine {
Engine numberOfCylinders;

    public Engine getNumberOfCylinders() {
        return numberOfCylinders;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "numberOfCylinders=" + numberOfCylinders +
                '}';
    }

    public void setNumberOfCylinders(Engine numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;

    }
}
