package com.example.resfebeenglish2;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionList {
    private ArrayList<QuestionCandidate> questions;

    public QuestionList(){
        questions = new ArrayList<>();
    }

    public void addQuestionCandidate(QuestionCandidate questionCandidate){
        questions.add(questionCandidate);
    }

    public int numberOfQuestions(){
        return questions.size();
    }

    public void shuffle(){
        Collections.shuffle(questions);
    }

    public QuestionCandidate getQuestion(int index){
        return questions.get(index);
    }
}
