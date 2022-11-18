package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuizMaker{
    public static void main(String[] args) throws Exception {
        Quiz a = new Quiz();
        a.loadFromFile("src/com/company/JavaQuiz.txt");
        if(a.toString()!=null) {
            System.out.println("Welcome to \"" + a.toString() + "\" QUIZ!\n");
            a.start();
        }




    }
}
