package com.company;

public class Fillin extends Question {

    public String toString(){
        return getDescription().replace("{blank}", "______" );

    }
}
