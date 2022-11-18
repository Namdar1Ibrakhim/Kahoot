package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test extends Question{
    private int numOfOptions;
    private String[] options;
    List<Character> labels = new ArrayList<>();

    public Test(int i) {
        this.numOfOptions=i;
        for (int j=0;j<numOfOptions;j++){
        labels.add((char) ('A'+j));
        }
    }

    public void setOptions(String[] r) {
        options = new String[numOfOptions];
        List<String> list = new ArrayList<>();

        for (int i = 0; i < r.length; i++) {  // отправим массив question без 1ого элемента
              list.add(r[i]);
        }
        Collections.shuffle(list);

        for (int i = 0; i < r.length; i++) {
            this.options[i] = list.get(i) ;
        }
    }

    public String getOptionAt(int ind) {
        return options[ind];
    }

    public String toString() {
        String res = getDescription() + "\n";
        for (int i = 0; i < options.length; i++) {
            res += /*(char)('A'+i)*/ labels.get(i)+") "+ options[i] + "\n";
        }
        return res;
    }
}
