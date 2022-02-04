package com.example.learn.app.model;

import java.util.List;

public class Car {

    //is this list is an object or attribute
    List<Integer> list;
    //Is this engine attribute or an object
    Engine engine;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "list=" + list +
                ", engine=" + engine +
                '}';
    }
}
