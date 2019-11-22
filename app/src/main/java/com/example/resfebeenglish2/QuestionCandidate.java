package com.example.resfebeenglish2;

import java.util.ArrayList;

public class QuestionCandidate {
    private ArrayList<Image> images;

    public QuestionCandidate(Image image1, Image image2){
        images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
    }

    public QuestionCandidate(Image image1, Image image2, Image image3){
        images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
    }

    public QuestionCandidate(Image image1, Image image2, Image image3, Image image4){
        images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
    }

    public Image getImage(int index){
        return images.get(index);
    }

    public String getAnswer(){
        String result = images.get(0).getWord();
        for (int i = 1; i < images.size(); i++){
            result = result + images.get(i).getWord();
        }
        return result;
    }
}
