package com.example.resfebeenglish2;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PictureDictionary {
    private ArrayList<Image> images;

    public PictureDictionary(Context current){
        images = new ArrayList<>();
        InputStream source = current.getResources().openRawResource(R.raw.kelime);
        Scanner input = new Scanner(source);
        int numberOfWords = input.nextInt();
        for (int i = 0; i < numberOfWords; i++){
            String dosyaNo = input.next();
            String kelime = input.next();
            Image image = new Image(dosyaNo, kelime);
            images.add(image);
        }
    }

    public int length(){
        return images.size();
    }

    public Image getImage(int numara){
        return images.get(numara);
    }

}
