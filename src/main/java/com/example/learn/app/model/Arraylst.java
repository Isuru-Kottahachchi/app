package com.example.learn.app.model;

import java.util.ArrayList;
import java.util.List;

public class Arraylst {

    List<Double> list = new ArrayList<Double>();

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Arraylst{" +
                "list=" + list +
                '}';
    }
}
