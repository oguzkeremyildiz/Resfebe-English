package com.example.resfebeenglish2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MediumScreen extends GeneralScreen {
    private ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medium_resfebe);
        controlButton = findViewById(R.id.controlButton);
        controlButton.setOnClickListener(controlClick);
        passButton = findViewById(R.id.passButton);
        passButton.setOnClickListener(passClick);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        answerText = findViewById(R.id.answerText);
        showQuestion();
    }

    protected void findCandidates(){
        questionList = new QuestionList();
        for (int i = 0; i < pictureDictionary.length(); i++){
            Image image1 = pictureDictionary.getImage(i);
            String word1 = image1.getWord();
            for (int j = 0; j < pictureDictionary.length(); j++){
                Image image2 = pictureDictionary.getImage(j);
                String word2 = image2.getWord();
                if (dictionary.anyWordsStartingWithPrefix(word1 + word2) && word1.length() * word2.length() > 1){
                    for (int k = 0; k < pictureDictionary.length(); k++){
                        Image image3 = pictureDictionary.getImage(k);
                        String word3 = image3.getWord();
                        if ((word1.length() > 1 && word2.length() > 1) || (word1.length() > 1 && word3.length() > 1) || (word2.length() > 1 && word3.length() > 1)){
                            String searchedWord = word1 + word2 + word3;
                            if (dictionary.wordExists(searchedWord) == true){
                                QuestionCandidate questionCandidate = new QuestionCandidate(image1, image2, image3);
                                questionList.addQuestionCandidate(questionCandidate);
                            }
                        }
                    }
                }
            }
        }
        Toast.makeText(getApplicationContext(), "" + questionList.numberOfQuestions(), Toast.LENGTH_LONG).show();
    }

    protected void showQuestion(){
        showPicture(image1, 0);
        showPicture(image2, 1);
        showPicture(image3, 2);
    }

}
