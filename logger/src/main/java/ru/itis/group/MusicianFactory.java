package ru.itis.group;

import ru.itis.group.musicians.*;

public class MusicianFactory {

    public Musician getMusician(String type){
        if (type.equals("drummer")){
            return new Drummer();
        }else if(type.equals("pianist")){
            return new Pianist();
        }else if(type.equals("trumpeter")){
            return new Trumpeter();
        }else if(type.equals("violinist")){
            return new Violinist();
        }else if(type.equals("guitarist")){
            return new Guitarist();
        }else {
            return null;
        }
    }
}
