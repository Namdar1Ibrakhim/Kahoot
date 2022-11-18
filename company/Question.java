package com.company;

import java.util.List;

public abstract class Question {
    private String description;
    private String answer;

    public String getDescription() {
        return description;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setDescription(String description) {

        this.description = description;
    }
    public String getAnswer() {
        return answer;
    }
}
