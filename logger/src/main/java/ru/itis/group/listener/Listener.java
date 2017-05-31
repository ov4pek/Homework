package ru.itis.group.listener;

import java.util.Random;

public class Listener {

    private String name;

    private Random random = new Random();

    public Listener(String name){
        this.name = name;
    }

    public void listen(){
        System.out.println("Listener " + name + " started to listen...");
    }

    public int getWinner(int quantity){
        return random.nextInt(quantity);
    }
}
