package com.example.resfebeenglish2;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    private ArrayList<String> wordArray;
    private HashSet<String> wordHashSet;

    public Dictionary(Context current){
        wordArray = new ArrayList<>();
        wordHashSet = new HashSet<>();
        InputStream source = current.getResources().openRawResource(R.raw.sozluk);
        Scanner input = new Scanner(source);
        int numberOfWords = input.nextInt();
        for (int i = 0; i < numberOfWords; i++){
            String word = input.next();
            wordArray.add(word);
            wordHashSet.add(word);
        }
        Collections.sort(wordArray);
    }

    public boolean wordExists(String word){
        return wordHashSet.contains(word);
    }

    public boolean anyWordsStartingWithPrefix(String word){
        int position = Collections.binarySearch(wordArray, word);
        if (position < 0){
            if ((-(position + 1)) < wordArray.size()){
                return wordArray.get(-(position + 1)).startsWith(word);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
