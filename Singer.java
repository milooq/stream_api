package com.company;

public class Singer {

    public String name;
    Country c;
    Type t;

    public Singer(String nameP,Country cP, Type tP ) {
        name = nameP;
        c = cP;
        t = tP;
    }

    public enum Country{
        RUSSIA, GERMANY, USA;
    }

    public enum Type{
        SOLO, BAND;
    }

    public String toString(){
        return name;
    }
}

