package ru.itis;

import ru.itis.group.listener.Listener;
import ru.itis.group.musicians.*;

import java.util.ArrayList;

public class Audition {

    private Listener listener;

    private ArrayList<Musician> members;

    public Audition() {
        members = new ArrayList<Musician>();
    }

    public void start() {
        listener.listen();
        try {
            for (Musician musician : members) {
                musician.play();
            }
            Musician winner = members.get(listener.getWinner(members.size()));
            System.out.println("Auditions finished. Listener think that " + winner.getClass().getSimpleName() + " wins");
        } catch (Exception e) {
            System.err.println("Members array is empty!");
        }
    }

    public void addMember(Musician musician) {
        members.add(musician);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
